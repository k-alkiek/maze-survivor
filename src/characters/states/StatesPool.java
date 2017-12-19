package characters.states;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public class StatesPool {
    private static State idleState = new IdleState(),
    reloadingState = new ReloadingState(),
    shootingState = new ShootingState(),
    walkingState = new WalkingState();

    public static State getNextState(String stateName) {
        if (stateName.equals("IdleState"))
            return idleState;
        else if (stateName.equals("ReloadingState"))
            return reloadingState;
        else if (stateName.equals("ShootingState"))
            return shootingState;
        else if (stateName.equals("WalkingState"))
            return walkingState;
        else
            return idleState;
    }
}
