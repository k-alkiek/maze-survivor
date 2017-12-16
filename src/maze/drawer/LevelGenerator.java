package maze.drawer;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class LevelGenerator {
    private int size;
    private Group root;
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
    
	public final void constructMaze() {

		this.initializeDrawables();
        this.generateMaze();
        this.spreadDestructableWalls();
        this.spreadMines();
        this.spreadHorizontalBigMines();
        this.spreadVerticalBigMines();
        this.spreadGifts();
	}

	public abstract void initializeDrawables();
	public abstract void generateMaze();
	public abstract void spreadDestructableWalls();
	public abstract void spreadMines();
	public abstract void spreadHorizontalBigMines();
	public abstract void spreadVerticalBigMines();
	public abstract void spreadGifts();
	
    public void displayDrawables() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                //Setting the image view
                if (maze[i][j] == '1') {
                    ImageView imageView = new ImageView(wall);

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
                    ImageView imageView = new ImageView(destructableWall);

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

                } else if (maze[i][j] == '4') {
                    ImageView imageViewLeft = new ImageView(bigMineLeft);
                    //Setting the position of the image
                    imageViewLeft.setX(5 + j * 25);
                    imageViewLeft.setY(5 + i * 25);

                    //setting the fit height and width of the image view
                    imageViewLeft.setFitHeight(25);
                    imageViewLeft.setFitWidth(25);

                    //Setting the preserve ratio of the image view
                    imageViewLeft.setPreserveRatio(true);
                    root.getChildren().addAll(imageViewLeft);
                                        
                } else if (maze[i][j] == '5') {
                	  ImageView imageViewRight = new ImageView(bigMineRight);

                      //Setting the position of the image
                      imageViewRight.setX(5 + j * 25);
                      imageViewRight.setY(5 + i * 25);

                      //setting the fit height and width of the image view
                      imageViewRight.setFitHeight(25);
                      imageViewRight.setFitWidth(25);

                      //Setting the preserve ratio of the image view
                      imageViewRight.setPreserveRatio(true);
                      root.getChildren().addAll(imageViewRight);

                } else if (maze[i][j] == '6') {
	              	  ImageView imageViewRight = new ImageView(bigMineUp);
	
	                  //Setting the position of the image
	                  imageViewRight.setX(5 + j * 25);
	                  imageViewRight.setY(5 + i * 25);
	
	                  //setting the fit height and width of the image view
	                  imageViewRight.setFitHeight(25);
	                  imageViewRight.setFitWidth(25);
	
	                  //Setting the preserve ratio of the image view
	                  imageViewRight.setPreserveRatio(true);
	                  root.getChildren().addAll(imageViewRight);

	            } else if (maze[i][j] == '7') {
		          	  ImageView imageViewRight = new ImageView(bigMineDown);
		
		              //Setting the position of the image
		              imageViewRight.setX(5 + j * 25);
		              imageViewRight.setY(5 + i * 25);
		
		              //setting the fit height and width of the image view
		              imageViewRight.setFitHeight(25);
		              imageViewRight.setFitWidth(25);
		
		              //Setting the preserve ratio of the image view
		              imageViewRight.setPreserveRatio(true);
		              root.getChildren().addAll(imageViewRight);
	
	            } else if (maze[i][j] == '8') {
		          	  ImageView imageViewRight = new ImageView(gift);
		
		              //Setting the position of the image
		              imageViewRight.setX(5 + j * 25);
		              imageViewRight.setY(5 + i * 25);
		
		              //setting the fit height and width of the image view
		              imageViewRight.setFitHeight(25);
		              imageViewRight.setFitWidth(25);
		
		              //Setting the preserve ratio of the image view
		              imageViewRight.setPreserveRatio(true);
		              root.getChildren().addAll(imageViewRight);
	
	            }
            }

        }
    }

}
