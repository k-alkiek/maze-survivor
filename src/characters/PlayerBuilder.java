package characters;

import game.GameEngine;
import gun.Pistol;
import gun.Revolver;
import gun.Shotgun;
import gun.Weapon;
import sound.SoundHandler;

/**
 * Created by khaled on 12/20/17.
 */
public class PlayerBuilder {

    public Player preparePlayerWithShotgun(GameEngine gameEngine, double x, double y, int bullets) {
        Player player = new Player(gameEngine, x, y);
        Shotgun shotgun = new Shotgun(bullets);
        player.setWeapon(shotgun);
        new Shadow(GameEngine.getInstanceOf(), player);
        return player;
    }

    public Player preparePlayerWithRevolver(double x, double y, int bullets) {
        Player player = new Player(GameEngine.getInstanceOf(), x, y);
        Revolver revolver = new Revolver(bullets);
        player.setWeapon(revolver);
        new Shadow(GameEngine.getInstanceOf(), player);
        return player;
    }

    public Player preparePlayerWithPistol(double x, double y, int bullets) {
        Player player = new Player(GameEngine.getInstanceOf(), x, y);
        Pistol pistol = new Pistol(bullets);
        player.setWeapon(pistol);
        new Shadow(GameEngine.getInstanceOf(), player);
        return player;
    }

    public Player buildPlayerWithWeapon(String chosenWeapon, double x, double y, int bullets) {
    	Player player = new Player(GameEngine.getInstanceOf(), x, y);
    	Weapon weapon;
    	switch (chosenWeapon) {
	    	case "Handgun": weapon = new Pistol(bullets); break;
	    	case "Shotgun": weapon = new Shotgun(bullets); break;
	    	case "Rifle": weapon = new Revolver(bullets); break;
	    	default: weapon = new Pistol(bullets);
    	}
        player.setWeapon(weapon);
        new Shadow(GameEngine.getInstanceOf(), player);
        return player;
    }

}
