package maze.drawer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import game.GameEngine;
import game.GameManager;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import maze.generateAlgorithm.MazeGenerator;

public abstract class LevelGenerator {
    protected int size;
    protected Pane root;
    protected double percentageOfDestructableWalls;
    protected double percentageOfMines;
    protected char[][] maze;
    protected static Image wall = null;
    protected static Image destroyedWall = null;
    protected static Image destructableWall = null;
    protected static Image mine = null;
    protected static Image horizontalBigMine = null;
    protected static Image verticalBigMine = null;
    public static Image gift = null;
    protected static Image ground = null;
    protected int numOfBullets;
    protected int numOfMonsters;
    protected GameEngine gameEngine = GameEngine.getInstanceOf();
    public GameManager gameManager = new GameManager(gameEngine, gameEngine.getPlayer());
    

    /**
	 * @return the numOfBullets
	 */
	public int getNumOfBullets() {
		return numOfBullets;
	}

	/**
	 * @return the numOfMonsters
	 */
	public int getNumOfMonsters() {
		return numOfMonsters;
	}

    
	/**
	 * 
	 */
	public LevelGenerator(Pane root, int size, double percentageOfDestructableWalls, double percentageOfMines) {
        this.size = size;
        this.root = root;
        this.percentageOfDestructableWalls = percentageOfDestructableWalls;
        this.percentageOfMines = percentageOfMines;
        maze = new char[size][size];
	}

	public final void constructMaze() {

        this.initializeDrawables();
        this.generateMaze();
        this.spreadDestructibleWalls();
        this.spreadHorizontalBigMines();
        this.spreadVerticalBigMines();
        this.spreadGifts();
        this.spreadMonsters();
	}

	private void initializeDrawables() {
        try {
        	if (ground == null) {
            ground = new Image(new FileInputStream("floor.jpg"));
        	}
            if (destroyedWall == null) {
            destroyedWall = new Image(new FileInputStream("floorDestroyed.png"));
            }
            if (wall == null) {
            wall = new Image(new FileInputStream("wall.jpg"));
            }
            if (destructableWall == null) {
            destructableWall = new Image(new FileInputStream("D_Wall.jpg"));
            }
            if (mine == null) {
            mine = new Image(new FileInputStream("mine.png"));
            }
            if (horizontalBigMine == null) {
            horizontalBigMine = new Image(new FileInputStream("dynamite-horizontal.png"));
            }
            if (verticalBigMine == null) {
            verticalBigMine = new Image(new FileInputStream("dynamite-vertical.png"));
            }
            if (gift == null) {
            gift = new Image(new FileInputStream("gift.jpg"));
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
	    
	    private void spreadDestructibleWalls() {
	        for (int i = 0; i < maze.length * maze.length * percentageOfDestructableWalls; i++) {
	            int randomXPos = (int) (Math.random() * maze.length);
	            int randomYPos = (int) (Math.random() * maze.length);
	            if (maze[randomYPos][randomXPos] != '2' && this.positionIsValid(maze, randomXPos, randomYPos)) {
	                maze[randomYPos][randomXPos] = '2';
	                if (maze[randomYPos][randomXPos] == ' ') {
	                	numOfBullets++;
	                }
	            } else {
	                i--;
	            }
	        }
	    }


	    private void spreadGifts() {
	        for (int i = 0; i < maze.length * maze.length * percentageOfMines; i++) {
	            int randomXPos = (int) (Math.random() * maze.length);
	            int randomYPos = (int) (Math.random() * maze.length);
	            if (maze[randomYPos][randomXPos] == ' '
	                    && this.positionIsValid(maze, randomXPos, randomYPos)) {
	                maze[randomYPos][randomXPos] = '8';
	            } else {
	                i--;
	            }
	        }
	    }
	    
	    private void spreadMonsters() {
	        for (int i = 0; i < maze.length * maze.length * percentageOfMines * 6; i++) {
	            int randomXPos = (int) (Math.random() * maze.length);
	            int randomYPos = (int) (Math.random() * maze.length);
	            if (maze[randomYPos][randomXPos] == ' '
	                    && this.positionIsValid(maze, randomXPos, randomYPos)) {
	            	this.numOfMonsters++;
	                maze[randomYPos][randomXPos] = '9';
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
	            	this.numOfBullets++;
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
	            	this.numOfBullets++;
	                maze[randomYPos][randomXPos] = '6';
	                maze[randomYPos + 1][randomXPos] = '7';
	            } else {
	                i--;
	            }
	        }
	    }

	
	    public void displayMaze() {
	        this.displayDrawables();
	    }
	    
	    public abstract void displayDrawables();
	
    
}
