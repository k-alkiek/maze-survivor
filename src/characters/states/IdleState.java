package characters.states;



import characters.Player;
import game.GameEngine;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Created by khaled on 12/13/17.
 */
public class IdleState extends State {
	
	
    public IdleState(String character) {
        super();
        String path = "src/assets/player/" + character + "/idle";
        loadSprites(path);
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
