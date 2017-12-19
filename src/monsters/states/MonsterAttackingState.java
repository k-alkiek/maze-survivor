package monsters.states;

import monsters.Monster;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class MonsterAttackingState extends MonsterState {
    public MonsterAttackingState() {
        super();
        loadSprites("src/assets/monsters/attack");
    }

    @Override
    public void update(Monster monster) {
    }
}
