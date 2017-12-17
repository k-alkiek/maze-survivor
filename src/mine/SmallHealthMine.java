package mine;

import game.GameEngine;
import game.GameManager;
import javafx.scene.image.ImageView;
import objects.CollidableGameObject;

/**
 * @author H
 *
 */
public class SmallHealthMine extends HealthMine  {

	private final static int HEALTH_DAMAGE = GameManager.getMaxHealth() / 2;

	public static ImageView graphics;

	public SmallHealthMine(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public int getDamage() {
		return HEALTH_DAMAGE;
	}

}
