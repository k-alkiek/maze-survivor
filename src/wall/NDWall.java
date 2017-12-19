package wall;

import game.GameEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NDWall extends Wall {

	protected final static String NOT_DESTRUCTABLE_WALL = "notDestructableWall";
	private final static boolean IS_DESTRUCTABLE = false;
	private static Image wallShape;

	public NDWall(GameEngine gameEngine, int x, int y) {
		super(gameEngine, x, y, IS_DESTRUCTABLE);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
