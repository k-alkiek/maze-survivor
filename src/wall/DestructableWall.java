package wall;

import game.GameEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class DestructableWall extends Wall implements IDestructable {

	protected final static String DESTRUCTABLE_WALL = "destructableWall";
	private final static boolean IS_DESTRUCTABLE = true;
	private static Image wallShape;
	private boolean isDestructed;

	public static void setWallShape(Image wallShape) {
		DestructableWall.wallShape = wallShape;
	}

	public DestructableWall(GameEngine gameEngine, int x, int y) {
		super(gameEngine, x, y, IS_DESTRUCTABLE);
	}
	
}
