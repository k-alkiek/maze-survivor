package objects;

import game.GameEngine;

/**
 * Created by khaled on 12/12/17.
 */
public class SampleGameObejct extends GameObject {
    public SampleGameObejct(GameEngine gameEngine) {
        super(gameEngine);
    }

    @Override
    public void update() {
        System.out.println("Update");
    }
}
