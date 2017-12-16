package characters.states;

import characters.Player;

/**
 * Created by khaledabdelfattah on 12/16/17.
 */
public class ReloadingWhileWalkingState extends State {
    public ReloadingWhileWalkingState() {
        super();
        loadSprites("src/assets/player/handgun/reload");
        framePerState = 0;
    }
    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);
        if (framePerState == sprites.size()) {
            framePerState = 0;
            if (walking()) {
                player.setCurrentState(new WalkingState());
            } else {
                player.setCurrentState(new IdleState());
            }
        }
    }
}
