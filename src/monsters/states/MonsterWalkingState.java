package monsters.states;

import monsters.Monster;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class MonsterWalkingState extends MonsterState {
    public MonsterWalkingState() {
        super();
        loadSprites("/Users/khaledabdelfattah/Downloads/export/move");
    }

    @Override
    public void update(Monster monster) {
        setSpritesPerFrame(monster);
        walk(monster);
    }
}
