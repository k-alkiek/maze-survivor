package characters.states;

import characters.Player;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class WalkingState extends State {
<<<<<<< HEAD
=======
    private int perFrame = 1, currFrame = 0;

>>>>>>> master
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
                player.setCurrentState(new ShootingState());
            } else {
                player.setCurrentState(new IdleState());
            }
        } else if (mouse.isPressed(MouseButton.PRIMARY) && walking()) {
            player.setCurrentState(new ShootingWhileWalkingState());
        } else if (keyboard.isPressed(KeyCode.R)) {
            if (walking()) {
                player.setCurrentState(new ReloadingWhileWalkingState());
            } else {
                player.setCurrentState(new ReloadingState());
            }
        }
    }
}
