package monsters.states;

import monsters.Monster;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class MonsterIdleState extends MonsterState {
    public MonsterIdleState() {
        super();
        loadSprites("/Users/khaledabdelfattah/Downloads/export/idle");
    }

    @Override
    public void update(Monster monster) {

    }
}
