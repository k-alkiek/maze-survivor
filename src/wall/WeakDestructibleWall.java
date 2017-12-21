package wall;

import game.GameEngine;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeakDestructibleWall extends DestructibleWall {

	public WeakDestructibleWall(GameEngine gameEngine, int x, int y) {
		super(gameEngine, x, y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hit(int damage) {
		Platform.runLater(() -> gameEngine.destroyGameObject(this));
	}

}
