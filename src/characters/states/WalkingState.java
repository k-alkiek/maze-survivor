package characters.states;

import characters.Player;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class WalkingState extends State {
    public WalkingState() {
        super();
        loadSprites("src/assets/player/handgun/move");
    }

    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);
        if (!walking()) {
            if (mouse.isPressed(MouseButton.PRIMARY)) {
                player.setCurrentState(StatesPool.getNextState("ShootingState"));
            } else {
                player.setCurrentState(StatesPool.getNextState("IdleState"));
            }
        } else if (mouse.isPressed(MouseButton.PRIMARY) && walking()) {
            player.setCurrentState(StatesPool.getNextState("ShootingState"));
        } else if (keyboard.isPressed(KeyCode.R)) {
            player.setCurrentState(StatesPool.getNextState("ReloadingState"));
        }
    }
}
