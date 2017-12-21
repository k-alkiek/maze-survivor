package wall;

import game.GameEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import objects.Destructible;

public abstract class DestructibleWall extends Wall implements Destructible {

	protected final static String DESTRUCTABLE_WALL = "destructableWall";
	private final static boolean IS_DESTRUCTABLE = true;
	private static Image wallShape;
	private boolean isDestructed;

	public static void setWallShape(Image wallShape) {
		DestructibleWall.wallShape = wallShape;
	}

	public DestructibleWall(GameEngine gameEngine, int x, int y) {
		super(gameEngine, x, y, IS_DESTRUCTABLE);
	}
	
}
