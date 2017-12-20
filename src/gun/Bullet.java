package gun;

import java.util.Iterator;
import java.util.List;

import characters.Player;
import game.GameEngine;
import javafx.application.Platform;
import javafx.scene.shape.Line;
import objects.*;

/**
 * A single fired bullet.
 * 
 * @author H
 *
 */
public class Bullet extends CollidableGameObject {

	private static final int LETHAL_RANGE = 100;

	/**
	 * Flag for whether this bullet is on action for collision with something.
	 */
	private boolean onFire;

	private int maxDamage;

	private Weapon weapon;

	private Line hitLine;

	private static final int OFFSET = 20;

	public Bullet(GameEngine gameEngine) {
		super(gameEngine);
	}

	public void fire(Player shooter, Weapon weapon) {
		System.out.println(this.hashCode());
		Player player = GameEngine.getInstanceOf().getPlayer();
		x = player.getX() + player.getImageView().getFitWidth() / 2;
		y = player.getY() + player.getImageView().getFitHeight() / 2;
		angle = player.getAngle();
		System.out.println(player.getAngle() + "ana ahoo");
		this.weapon = weapon;
		maxDamage = weapon.getDamage();
		onFire = true;
		hitLine = new Line(x, y, x, y);
		gameEngine.getPane().getChildren().add(hitLine);
		if (weapon.isRanged()) {
			hitLine.setStrokeWidth(5.0);
		}
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
			hitLine.setEndX(hitLine.getEndX() + OFFSET * Math.cos(Math.toRadians(angle)));
			hitLine.setEndY(hitLine.getEndY() + OFFSET * Math.sin(Math.toRadians(angle)));
			Iterator<GameObject> i = gameEngine.getGameObjects().iterator();
			while (i.hasNext()) {
				GameObject object = i.next();
				if (object != gameEngine.getPlayer() && object instanceof CollidableGameObject
						&& hitLine.intersects(((CollidableGameObject) object).getImageView().getBoundsInLocal())) {
					onFire = false;
					BulletPool.getInstance(gameEngine.getPlayer()).releaseReusable(this);
					gameEngine.getPane().getChildren().remove(hitLine);
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
