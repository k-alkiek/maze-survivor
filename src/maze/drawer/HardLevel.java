package maze.drawer;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mine.AbstractMineFactory;
import mine.BigHealthMine;
import mine.BigScoreMine;
import mine.MineHardFactory;
import monsters.Monster;
import objects.CollidableGameObject;
import pickup.AbstractPickupFactory;
import pickup.PickupHardFactory;
import wall.NDWall;
import wall.WeakDestructibleWall;

public class HardLevel extends LevelGenerator {

	public HardLevel(Pane root, int size, double percentageOfDestructableWalls, double percentageOfMines) {
		super(root, size, percentageOfDestructableWalls, percentageOfMines);
	}

	@Override
	public void displayDrawables() {
		int cellSize = 70;
        new Monster(gameManager, 5 + (maze.length - 3) * cellSize, 5 + (maze.length - 3) * cellSize);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
            	if (maze[i][j] != '1' && maze[i][j] != '2') {
	            	ImageView ground = new ImageView();
	            	ground.setX(5 + j * cellSize);
	            	ground.setY(5 + i * cellSize);
	            	ground.setFitWidth(70);
	            	ground.setFitHeight(70);
	            	ground.setPreserveRatio(true);
	            	ground.setImage(this.ground);
	                gameEngine.getPane().getChildren().add(ground);
	            	ground.toBack();
	            }
                if (maze[i][j] == '2') {
                    ImageView ground = new ImageView();
                    ground.setX(5 + j * cellSize);
                    ground.setY(5 + i * cellSize);
                    ground.setFitWidth(70);
                    ground.setFitHeight(70);
                    ground.setPreserveRatio(true);
                    ground.setImage(this.destroyedWall);
                    gameEngine.getPane().getChildren().add(ground);
                    ground.toBack();
                }
                if (maze[i][j] == '1') {
                    CollidableGameObject wall = new NDWall(gameEngine, 5 + j * cellSize, 5 + i * cellSize);
                    wall.draw(this.wall);
                } else if (maze[i][j] == '2') {
                	CollidableGameObject wall = new WeakDestructibleWall(gameEngine, 5 + j * cellSize, 5 + i * cellSize);
                	wall.draw(this.destructableWall);
                } else if (maze[i][j] == '4') {
                	AbstractMineFactory mineFactory = new MineHardFactory(this.gameManager);
                	CollidableGameObject mine = (CollidableGameObject) mineFactory.createMine(5 + j * cellSize, 5 + i * cellSize);
                	if (mine instanceof BigHealthMine || mine instanceof BigScoreMine) {
                        mine.draw(this.horizontalBigMine);
                    } else {
                        mine.draw(this.mine);
                    }
                } else if (maze[i][j] == '6') {
                	AbstractMineFactory mineFactory = new MineHardFactory(this.gameManager);
                	CollidableGameObject mine = (CollidableGameObject) mineFactory.createMine(5 + j * cellSize, 5 + i * cellSize);
                    if (mine instanceof BigHealthMine || mine instanceof BigScoreMine) {
                        mine.draw(this.verticalBigMine);
                    } else {
                        mine.draw(this.mine);
                    }	            
                }  else if (maze[i][j] == '8') {
	            	AbstractPickupFactory mineFactory = new PickupHardFactory(this.gameManager);
                	CollidableGameObject gift = (CollidableGameObject) mineFactory.createPickup(5 + j * cellSize, 5 + i * cellSize);
                	gift.draw(this.gift);
	            } else if (maze[i][j] == '9') {
	            	new Monster(gameManager, 5 + j * cellSize, 5 + i * cellSize);
	            }
            }
        }		
	}



}
