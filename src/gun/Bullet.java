package gun;

import java.util.List;

import characters.Player;
import game.GameEngine;
import javafx.scene.shape.Line;
import objects.*;

/**
 * A single fired bullet.
 * 
 * @author H
 *
 */
public class Bullet extends CollidableGameObject {

	private static final int LETHAL_RANGE = 25;

	/**
	 * Flag for whether this bullet is on action for collision with something.
	 */
	private boolean onFire;

	private int maxDamage;

	private Weapon weapon;

	private Line hitLine;

	private static final int OFFSET = 10;

	public Bullet(GameEngine gameEngine) {
		super(gameEngine);
	}

	public void fire(Player shooter, Weapon weapon) {
		x = shooter.getX();
		y = shooter.getY();
		angle = shooter.getAngle();
		this.weapon = weapon;
		maxDamage = weapon.getDamage();
		onFire = true;
		hitLine = new Line(x, y, x, y);
		if (weapon.isRanged()) {
			hitLine.setStrokeWidth(5.0);
		}
		gameEngine.addGameObject(this);
	}

	/**
	 * @return the onFire
	 */
	public final boolean isOnFire() {
		return onFire;
	}

	@Override
	public void update() {
		if (onFire) {
			hitLine.setEndX(hitLine.getStartX() + OFFSET * Math.cos(angle));
			hitLine.setEndY(hitLine.getStartY() + OFFSET * Math.sin(angle));
			for (GameObject object : gameEngine.getGameObjects()) {
				if (object instanceof CollidableGameObject && hitLine.intersects(((CollidableGameObject) object).getImageView().getBoundsInLocal())) {
					onFire = false;
					gameEngine.destroyGameObject(this);
					if (object instanceof Destructible) {
						((Destructible) object).hit(getHitDamage());
					}
				}
			}
		}
	}

	private int getHitDamage() {
		if (weapon.isRanged()) {
			double distance = this.getHitDistance();
			if (distance > LETHAL_RANGE) {
				return (int) (LETHAL_RANGE / distance * maxDamage);
			}
		}
		return maxDamage;
	}

	private double getHitDistance() {
		double hitWidth = Math.abs(hitLine.getEndX() - hitLine.getStartX());
		double hitLength = Math.abs(hitLine.getEndY() - hitLine.getStartY());
		double hitDistance = Math.sqrt(Math.pow(hitWidth, 2) + Math.pow(hitLength, 2));
		return hitDistance;
	}

}
