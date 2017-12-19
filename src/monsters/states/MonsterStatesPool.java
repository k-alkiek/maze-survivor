package monsters.states;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public class MonsterStatesPool {
    private static MonsterState idleState = new MonsterIdleState(),
            attackingState = new MonsterAttackingState(),
            walkingState = new MonsterWalkingState();

    public static MonsterState getNextState(String stateName) {
        if (stateName.equals("IdleState"))
            return idleState;
        else if (stateName.equals("AttackingState"))
            return attackingState;
        else if (stateName.equals("WalkingState"))
            return walkingState;
        else
            return idleState;
    }
}
