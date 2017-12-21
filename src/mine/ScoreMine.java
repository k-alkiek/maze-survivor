package mine;

import game.GameManager;
import javafx.application.Platform;
import objects.CollidableGameObject;
import objects.Destructible;

/**
 * Score decreasing mine applying Template Design Pattern.
 * @author H.
 *
 */
public abstract class ScoreMine extends CollidableGameObject implements Mine, Destructible {

	private GameManager gameManager;

	/**
	 * States whether the mine gets vanished once the player hits it.
	 */
	protected boolean destroyable;

	/**
	 * The constructor keeps the coordinates of the mine and sets the
	 * destroyable value to true by default.
	 * An undestroyable ScoreMine normally would reset destroyable to false
	 * as this is not common for mines in general.
	 * @param gameManager
	 * @param x
	 * @param y
	 */
	public ScoreMine(GameManager gameManager, double x, double y) {
		super(gameManager.getGameEngine(), x, y);
		this.gameManager = gameManager;
		destroyable = true;
	}

	@Override
	public void update() {
		if (gameManager.getPlayer().collidesWith(this)) {
			gameManager.decreaseScore(this.getDamage());
			if (destroyable) {
				gameEngine.destroyGameObject(this);
			}
		}
	}

	@Override
	public void hit(int damage) {
		Platform.runLater(() -> gameEngine.destroyGameObject(this));
	}

}
