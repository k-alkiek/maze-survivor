package mazeDrawer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import maze.generateAlgorithm.MazeGenerator;

public class MazeDrawer {
	private int size;
    private Group root;
    private double percentageOfDestructableWalls;
    private double percentageOfMines;
    char[][] maze;
    Image image = null;
    Image imageDestructable = null;
    Image mine = null;

	public MazeDrawer(Group root, int size, double percentageOfDestructableWalls, double percentageOfMines) {
		super();
		this.size = size;
		this.root = root;
		this.percentageOfDestructableWalls = percentageOfDestructableWalls;
		this.percentageOfMines = percentageOfMines;
		maze = new char[size][size];
	}
	
    private boolean positionIsValid(char[][] maze, int randomXPos, int randomYPos) {
    	Integer realMazeLength = maze.length;
    	if (realMazeLength % 2 == 0) {
    		realMazeLength--;
    	}
    	if (randomXPos < realMazeLength - 1
    			&& randomYPos < realMazeLength - 1
    			&& randomXPos != 0
    			&& randomYPos != 0
    			&& (randomXPos > 4
    			|| randomYPos > 4)) {
    		return true;
    	}
    	return false;
    }

    private void initializeDrawables() {                  
        try {
            image = new Image(new FileInputStream("wall.png"));
            imageDestructable = new Image(new FileInputStream("wall.jpg"));
            mine = new Image(new FileInputStream("mine.png"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void generateMaze() {
        MazeGenerator mazeGenerator = new MazeGenerator((size - 1) / 2, (size - 1) /2 );
        String printedMaze = mazeGenerator.getMaze();
        int index = 0;
        int row = 0;
        int column = 0;
        try {
	        while (true) {
	        	if (!(printedMaze.charAt(index) == '\n')) {
	        		maze[row][column] = printedMaze.charAt(index++);
	        		column++;
	        	} else {
	        		column = 0;
	        		index++;
	        		row++;
	        	}
	        }
        } catch (Exception e) {
        	System.out.println("MazeDrawer class: generateMazeFunction => maze converted");
        }
    }
    
    private void displayDrawables() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                //Setting the image view
                if (maze[i][j] == '1') {
                    ImageView imageView = new ImageView(image);

                    //Setting the position of the image
                    imageView.setX(5 + j * 25);
                    imageView.setY(5 + i * 25);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(25);
                    imageView.setFitWidth(25);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);

                    root.getChildren().addAll(imageView);
                } else if (maze[i][j] == '2') {
                	ImageView imageView = new ImageView(imageDestructable);

                    //Setting the position of the image
                    imageView.setX(5 + j * 25);
                    imageView.setY(5 + i * 25);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(25);
                    imageView.setFitWidth(25);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);
                    root.getChildren().addAll(imageView);

                } else if (maze[i][j] == '3') {
                	ImageView imageView = new ImageView(mine);

                    //Setting the position of the image
                    imageView.setX(5 + j * 25);
                    imageView.setY(5 + i * 25);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(25);
                    imageView.setFitWidth(25);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);
                    root.getChildren().addAll(imageView);

                }
            }

        }
    }
    
    private void spreadDestructableWalls() {
        int numOfDestructableWallsInFreePath = 0;
        for (int i = 0; i < maze.length * maze.length * percentageOfDestructableWalls; i++) {
        	int randomXPos = (int) (Math.random() * maze.length);
        	int randomYPos = (int) (Math.random() * maze.length);
        	if (maze[randomYPos][randomXPos] != '2' && this.positionIsValid(maze, randomXPos, randomYPos)) {
        		maze[randomYPos][randomXPos] = '2';
        		if (maze[randomYPos][randomXPos] == ' ') {
        			numOfDestructableWallsInFreePath++;
            	} 
        	} else {
        		i--;
        	}
        }
    }
    
    private void spreadMines() {
        for (int i = 0; i < maze.length * maze.length * percentageOfMines; i++) {
        	int randomXPos = (int) (Math.random() * maze.length);
        	int randomYPos = (int) (Math.random() * maze.length);
        	if (maze[randomYPos][randomXPos] != '1' && maze[randomYPos][randomXPos] != '2' && maze[randomYPos][randomXPos] != '3' && this.positionIsValid(maze, randomXPos, randomYPos)) {
        		maze[randomYPos][randomXPos] = '3';
        	} else {
        		i--;
        	}
        }
    }
    
	public void drawMaze() {
		this.initializeDrawables();
		this.generateMaze();
		this.spreadDestructableWalls();
		this.spreadMines();
        this.displayDrawables();
	}
}
