package characters.states;

import game.Keyboard;
import game.Mouse;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Created by khaledabdelfattah on 12/16/17.
 */
public class StatesFactory {
    private static State nextState;
    private static Keyboard keyboard;
    private static Mouse mouse;

    public static final State getNextState() {
        keyboard = Keyboard.getInstanceOf();
        mouse = Mouse.getInstanceOf();
        if (!walking() && mouse.getButtonsPressed().isEmpty()) {
            nextState = new IdleState();
        } else if (walking()) {
            if (!mouse.getButtonsPressed().isEmpty()) {
                nextState = new ShootingWhileWalkingState();
            } else {
                nextState = new WalkingState();
            }
        } else if (!walking() && mouse.isPressed(MouseButton.PRIMARY)) {
            nextState = new ShootingState();
        } else if (keyboard.isPressed(KeyCode.R)) {
            if (walking()) {
                nextState = new ReloadingWhileWalkingState();
            } else {
                nextState = new ReloadingState();
            }
        }
        return nextState;
    }

    private static boolean walking() {
        boolean isPressed = false;
        isPressed |= keyboard.isPressed(KeyCode.W);
        isPressed |= keyboard.isPressed(KeyCode.D);
        isPressed |= keyboard.isPressed(KeyCode.S);
        isPressed |= keyboard.isPressed(KeyCode.A);
        return isPressed;
    }
}
