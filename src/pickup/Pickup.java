package pickup;

/**
 * Pickups in the game. Assumed only pickable by the player.
 * 
 * @author H
 *
 */
public interface Pickup {

	/**
	 * Method called when the character picks up the pickup.
	 */
	public void pickup();

}
