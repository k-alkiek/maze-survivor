package maze.drawer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import maze.generateAlgorithm.MazeGenerator;

public class MazeDrawer {
    private int size;
    private Pane root;
    private double percentageOfDestructableWalls;
    private double percentageOfMines;
    private char[][] maze;
    private Image wall = null;
    private Image destructableWall = null;
    private Image mine = null;
    private Image bigMineRight = null;
    private Image bigMineLeft = null;
    private Image bigMineUp = null;
    private Image bigMineDown = null;
	private Image gift = null;
    public static ArrayList<ImageView> imageViews = new ArrayList<ImageView>();


    public MazeDrawer(Pane root, int size, double percentageOfDestructableWalls, double percentageOfMines) {
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
            wall = new Image(new FileInputStream("wall.png"));
            destructableWall = new Image(new FileInputStream("wall.jpg"));
            mine = new Image(new FileInputStream("mine.png"));
            bigMineRight = new Image(new FileInputStream("bigMineRight.png"));
            bigMineLeft = new Image(new FileInputStream("bigMineLeft.png"));
            bigMineUp = new Image(new FileInputStream("bigMineUp.png"));
            bigMineDown = new Image(new FileInputStream("bigMineDown.png"));
            gift = new Image(new FileInputStream("gift.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void generateMaze() {
        MazeGenerator mazeGenerator = new MazeGenerator((size - 1) / 2, (size - 1) / 2);
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
            System.out.println("MazeDrawer class: generateMazeFunction => maze converted successfully");
        }
    }

    private void displayDrawables() {
    	int cellSize = 70;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                //Setting the image view
                if (maze[i][j] == '1') {
                    ImageView imageView = new ImageView(wall);
                    imageViews.add(imageView);

                    //Setting the position of the image
                    imageView.setX(5 + j * cellSize);
                    imageView.setY(5 + i * cellSize);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(cellSize);
                    imageView.setFitWidth(cellSize);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);

                    root.getChildren().addAll(imageView);
                } else if (maze[i][j] == '2') {
                    ImageView imageView = new ImageView(destructableWall);
                    imageViews.add(imageView);
                    //Setting the position of the image
                    imageView.setX(5 + j * cellSize);
                    imageView.setY(5 + i * cellSize);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(cellSize);
                    imageView.setFitWidth(cellSize);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);
                    root.getChildren().addAll(imageView);

                } else if (maze[i][j] == '3') {
                    ImageView imageView = new ImageView(mine);
                    imageViews.add(imageView);
                    //Setting the position of the image
                    imageView.setX(5 + j * cellSize);
                    imageView.setY(5 + i * cellSize);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(cellSize);
                    imageView.setFitWidth(cellSize);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);
                    root.getChildren().addAll(imageView);

                } else if (maze[i][j] == '4') {
                    ImageView imageViewLeft = new ImageView(bigMineLeft);
                    imageViews.add(imageViewLeft);
                    //Setting the position of the image
                    imageViewLeft.setX(5 + j * cellSize);
                    imageViewLeft.setY(5 + i * cellSize);

                    //setting the fit height and width of the image view
                    imageViewLeft.setFitHeight(cellSize);
                    imageViewLeft.setFitWidth(cellSize);

                    //Setting the preserve ratio of the image view
                    imageViewLeft.setPreserveRatio(true);
                    root.getChildren().addAll(imageViewLeft);
                                        
                } else if (maze[i][j] == '5') {
                	  ImageView imageViewRight = new ImageView(bigMineRight);
                	  imageViews.add(imageViewRight);
                      //Setting the position of the image
                      imageViewRight.setX(5 + j * cellSize);
                      imageViewRight.setY(5 + i * cellSize);

                      //setting the fit height and width of the image view
                      imageViewRight.setFitHeight(cellSize);
                      imageViewRight.setFitWidth(cellSize);

                      //Setting the preserve ratio of the image view
                      imageViewRight.setPreserveRatio(true);
                      root.getChildren().addAll(imageViewRight);

                } else if (maze[i][j] == '6') {
	              	  ImageView imageViewRight = new ImageView(bigMineUp);
	              	  imageViews.add(imageViewRight);
	                  //Setting the position of the image
	                  imageViewRight.setX(5 + j * cellSize);
	                  imageViewRight.setY(5 + i * cellSize);
	
	                  //setting the fit height and width of the image view
	                  imageViewRight.setFitHeight(cellSize);
	                  imageViewRight.setFitWidth(cellSize);
	
	                  //Setting the preserve ratio of the image view
	                  imageViewRight.setPreserveRatio(true);
	                  root.getChildren().addAll(imageViewRight);

	            } else if (maze[i][j] == '7') {
		          	  ImageView imageViewRight = new ImageView(bigMineDown);
		          	  imageViews.add(imageViewRight);
		              //Setting the position of the image
		              imageViewRight.setX(5 + j * cellSize);
		              imageViewRight.setY(5 + i * cellSize);
		
		              //setting the fit height and width of the image view
		              imageViewRight.setFitHeight(cellSize);
		              imageViewRight.setFitWidth(cellSize);
		
		              //Setting the preserve ratio of the image view
		              imageViewRight.setPreserveRatio(true);
		              root.getChildren().addAll(imageViewRight);
	
	            } else if (maze[i][j] == '8') {
		          	  ImageView imageViewRight = new ImageView(gift);
		          	  imageViews.add(imageViewRight);
		              //Setting the position of the image
		              imageViewRight.setX(5 + j * cellSize);
		              imageViewRight.setY(5 + i * cellSize);
		
		              //setting the fit height and width of the image view
		              imageViewRight.setFitHeight(cellSize);
		              imageViewRight.setFitWidth(cellSize);
		
		              //Setting the preserve ratio of the image view
		              imageViewRight.setPreserveRatio(true);
		              root.getChildren().addAll(imageViewRight);
	
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
            if (maze[randomYPos][randomXPos] == ' ' && this.positionIsValid(maze, randomXPos, randomYPos)) {
                maze[randomYPos][randomXPos] = '3';
            } else {
                i--;
            }
        }
    }
    
    private void spreadGifts() {
        for (int i = 0; i < maze.length * maze.length * percentageOfMines; i++) {
            int randomXPos = (int) (Math.random() * maze.length);
            int randomYPos = (int) (Math.random() * maze.length);
            if (maze[randomYPos][randomXPos] != '1'
            		&& maze[randomYPos][randomXPos] != '2'
                    && maze[randomYPos][randomXPos] != '3'
                    && maze[randomYPos][randomXPos] != '4'
                    && maze[randomYPos][randomXPos] != '5'
                    && maze[randomYPos][randomXPos] != '6'
                    && maze[randomYPos][randomXPos] != '7'
                    && maze[randomYPos][randomXPos] != '8'
                    && this.positionIsValid(maze, randomXPos, randomYPos)) {
                maze[randomYPos][randomXPos] = '8';
            } else {
                i--;
            }
        }
    }
    
    private boolean notHorizontalMine(int randomYPos, int randomXPos) {
    	if (maze[randomYPos][randomXPos] == ' ' && this.positionIsValid(maze, randomXPos, randomYPos)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    private void spreadHorizontalBigMines() {
        for (int i = 0; i < maze.length * maze.length * percentageOfMines; i++) {
            int randomXPos = (int) (Math.random() * maze.length);
            int randomYPos = (int) (Math.random() * maze.length);
            if (this.notHorizontalMine(randomYPos, randomXPos) && this.notHorizontalMine(randomYPos, randomXPos + 1)) {
                maze[randomYPos][randomXPos] = '4';
                maze[randomYPos][randomXPos + 1] = '5';
            } else {
                i--;
            }
        }
    }
    
    private boolean notVerticalMine(int randomYPos, int randomXPos) {
    	if (maze[randomYPos][randomXPos] == ' '
    	        && this.positionIsValid(maze, randomXPos, randomYPos)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    private void spreadVerticalBigMines() {
        for (int i = 0; i < maze.length * maze.length * percentageOfMines; i++) {
            int randomXPos = (int) (Math.random() * maze.length);
            int randomYPos = (int) (Math.random() * maze.length);
            if (this.notVerticalMine(randomYPos, randomXPos) && this.notVerticalMine(randomYPos + 1, randomXPos)) {
                maze[randomYPos][randomXPos] = '6';
                maze[randomYPos + 1][randomXPos] = '7';
            } else {
                i--;
            }
        }
    }

    public void constructMaze() {
        this.initializeDrawables();
        this.generateMaze();
        this.spreadDestructableWalls();
        this.spreadMines();
        this.spreadHorizontalBigMines();
        this.spreadVerticalBigMines();
        this.spreadGifts();
    }
    
    public void displayMaze() {
    	this.displayDrawables();
    }
}
