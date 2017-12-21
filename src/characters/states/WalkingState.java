package characters.states;

import characters.Player;
import game.GameEngine;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class WalkingState extends State {
    public WalkingState(String character) {
        super();
        String path = "src/assets/player/" + character + "/move";
        loadSprites(path);
    }

    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);
        if (!walking()) {
            if (mouse.isPressed(MouseButton.PRIMARY) || keyboard.isPressed(KeyCode.SPACE)) {
                player.setCurrentState(StatesPool.getNextState("ShootingState"));
            } else {
                player.setCurrentState(StatesPool.getNextState("IdleState"));
            }
        } else if ((mouse.isPressed(MouseButton.PRIMARY) && walking()) || keyboard.isPressed(KeyCode.SPACE)) {
            player.setCurrentState(StatesPool.getNextState("ShootingState"));
        } else if (keyboard.isPressed(KeyCode.R)) {
            player.setCurrentState(StatesPool.getNextState("ReloadingState"));
        }
    }
}
