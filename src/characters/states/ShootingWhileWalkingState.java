package characters.states;

import characters.Player;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ShootingWhileWalkingState extends State {
    public ShootingWhileWalkingState() {
        super();
        loadSprites("src/assets/player/handgun/shoot");
        framePerState = 0;
    }
    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);
        if (framePerState == sprites.size()) {
            framePerState = 0;
            player.setCurrentState(new WalkingState());
        }
    }
}
