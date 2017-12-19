package wall;

import game.GameEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import objects.CollidableGameObject;
import objects.GameObject;

public abstract class Wall extends CollidableGameObject{
	public final static int dimention = 70;
	private boolean isDestructable;

	public Wall(GameEngine gameEngine, int xPos, int yPos, boolean isDestructable) {
		super(gameEngine, xPos, yPos);
		this.isDestructable = isDestructable;
	}
	
	public boolean isDestructable() {
		return isDestructable;
	}
	public void setDestructable(boolean isDestructable) {
		this.isDestructable = isDestructable;
	}
}
