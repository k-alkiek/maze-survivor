package characters.states;

import characters.Player;
import game.GameEngine;
import javafx.scene.media.AudioClip;

import java.io.File;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ReloadingState extends State {
    private AudioClip reloadSound;
    private boolean reloadSoundPlayed;

    public ReloadingState() {
        super();
        loadSprites("src/assets/player/handgun/reload");
        reloadSound = new AudioClip(new File("src/assets/player/sounds/reload.wav").toURI().toString());
        reloadSoundPlayed = false;
        framePerState = 0;
    }
    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);

        if (!reloadSoundPlayed) {
            GameEngine.getInstanceOf().getSoundHandler().playSound(reloadSound, 0.5, true);
            reloadSoundPlayed = true;
        }

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
