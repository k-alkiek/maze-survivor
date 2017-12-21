package mine;

import game.GameManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import objects.CollidableGameObject;

/**
 * Big health mine.
 * @author H
 *
 */
public class BigHealthMine extends HealthMine {

	private final static int HEALTH_DAMAGE = GameManager.getMaxHealth();

	public static ImageView graphics;

	public BigHealthMine(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public int getDamage() {
		return HEALTH_DAMAGE;
	}

}
