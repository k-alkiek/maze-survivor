package characters.states;

import characters.Player;

/**
 * Created by khaled on 12/13/17.
 */
public class IdleState extends State {
    private int perFrame = 5;
    private int currFrame = 0;
    public IdleState() {
        super();
        loadSprites("src/assets/player/handgun/idle");
        System.out.println(sprites.size());
    }

    @Override
    public void update(Player player) {
        currFrame++;
        if (currFrame >= perFrame) {
            player.setSprite(spritesIterator.getCurrentImage());
            currFrame = 0;
        }

    }
}
