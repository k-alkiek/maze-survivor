package pickup;

import game.GameManager;
import gun.WeaponBooster;
import javafx.scene.image.ImageView;

public class DamageBoostPickup extends Pickup{
	private static final double BOOST_RATIO = 25;
	public static ImageView graphic;

	public DamageBoostPickup(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public void onPickup() {
		if (!picked) {
			WeaponBooster weaponBooster = new WeaponBooster(gameEngine.getPlayer().getWeapon());
			gameEngine.getPlayer().setWeapon(weaponBooster);
			picked = true;
		}
	}
}
