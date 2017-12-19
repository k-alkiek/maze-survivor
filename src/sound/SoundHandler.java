package sound;

import characters.Player;
import javafx.scene.media.AudioClip;
import objects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/19/17.
 */
public class SoundHandler {
    /**
     * The game object that receives sound.
     * Volume of sound effects are affected by their distance from the receiver.
     */
    private GameObject receiver;

    /**
     * The maximum radius in which the receiver can hear sounds.
     */
    private double audibleRadius;

    List<AudioClip> soundsPlaying;

    public SoundHandler(GameObject receiver) {
        this.receiver = receiver;
        audibleRadius = 300;
        soundsPlaying = new ArrayList<>();
    }

    public void playSound(AudioClip audioClip) {
        audioClip.setVolume(1);
        audioClip.play();
    }

    public void playSound(AudioClip audioClip, double volumeFactor) {
        audioClip.setVolume(volumeFactor);
        soundsPlaying.add(audioClip);
        audioClip.play();
    }

    public void playSound(AudioClip audioClip, double x, double y) {
        double distance = Math.sqrt(Math.pow((receiver.getX() - x), 2) + Math.pow((receiver.getY()- y), 2));
        if (distance > audibleRadius) return;

        double volume = 1 - distance / audibleRadius;
        playSound(audioClip, volume);
    }

    public void playSound(AudioClip audioClip, double x, double y, double volumeFactor) {
        double distance = Math.sqrt(Math.pow((receiver.getX() - x), 2) + Math.pow((receiver.getY()- y), 2));
        if (distance > audibleRadius) return;

        double volume = 1 - distance / audibleRadius;
        playSound(audioClip, volume * volumeFactor);
    }
    

}
