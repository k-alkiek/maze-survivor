package characters.states;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public class StatesPool {
    private static State idleState,
            reloadingState,
            shootingState,
            walkingState;

    public static void setStatesPool(String character) {
        idleState = new IdleState(character);
        reloadingState = new ReloadingState(character);
        shootingState = new ShootingState(character);
        walkingState = new WalkingState(character);
    }

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
