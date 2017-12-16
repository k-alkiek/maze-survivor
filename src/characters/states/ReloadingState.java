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
        setSpritesPerFrame(player);
        if (framePerState == sprites.size()) {
            framePerState = 0;
            player.setCurrentState(new IdleState());
        }
    }
}
