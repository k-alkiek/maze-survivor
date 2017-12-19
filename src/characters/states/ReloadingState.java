package characters.states;

import characters.Player;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ReloadingState extends State {
    public ReloadingState() {
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
                player.setCurrentState(StatesPool.getNextState("WalkingState"));
            } else {
                player.setCurrentState(StatesPool.getNextState("IdleState"));
            }
        }
    }
}
