package characters.states;

import characters.Player;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Created by khaled on 12/13/17.
 */
public class IdleState extends State {
    public IdleState() {
        super();
        loadSprites("src/assets/player/handgun/idle");
    }

    @Override
    public void update(Player player) {
        setSpritesPerFrame(player);
        if (keyboard.isPressed(KeyCode.R)) {
                player.setCurrentState(StatesPool.getNextState("ReloadingState"));
        } else if (walking()) {
            if (mouse.isPressed(MouseButton.PRIMARY)) {
                player.setCurrentState(StatesPool.getNextState("ShootingState"));
            } else {
                player.setCurrentState(StatesPool.getNextState("WalkingState"));
            }
        } else if (!walking() && mouse.isPressed(MouseButton.PRIMARY)) {
            player.setCurrentState(StatesPool.getNextState("ShootingState"));
        }
    }
}
