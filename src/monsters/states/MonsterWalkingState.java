package monsters.states;

import monsters.Monster;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class MonsterWalkingState extends MonsterState {
    public MonsterWalkingState() {
        super();
        loadSprites("src/assets/monsters/move");
    }

    @Override
    public void update(Monster monster) {
        setSpritesPerFrame(monster);
        walk(monster);
    }
}
