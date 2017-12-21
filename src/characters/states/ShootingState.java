package characters.states;

import characters.Player;
import game.GameEngine;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ShootingState extends State {
    public ShootingState(String character) {
        super();
        String path = "src/assets/player/" + character + "/shoot";
        loadSprites(path);
        framePerState = 0;
    }

    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);

        player.getWeapon().fire();

        if (framePerState == sprites.size()) {
            framePerState = 0;
            if (walking()) {
                player.setCurrentState(StatesPool.getNextState("WalkingState"));
            } else {
                player.setCurrentState(StatesPool.getNextState("IdleState"));
            }
        }
    }
}
