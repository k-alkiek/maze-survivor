package monsters.states;

import monsters.Monster;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class MonsterAttakingState extends MonsterState {
    public MonsterAttakingState() {
        super();
        loadSprites("/Users/khaledabdelfattah/Downloads/export/attack");
    }

    @Override
    public void update(Monster monster) {

    }
}
