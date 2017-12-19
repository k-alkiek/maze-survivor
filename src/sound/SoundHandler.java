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

    /**
     * Plays a sound effect from an audio clip
     * @param soundClip input audioClip object
     * @param volumeFactor volume of the sound
     * @param overPlay if set to false, the sound will only be played it is not already being played.
     *                 if set to true, the sound will be played anyway.
     */
    public void playSound(AudioClip soundClip, double volumeFactor, boolean overPlay) {
        if (!overPlay && soundIsPlaying(soundClip)) return;
        soundClip.setVolume(volumeFactor);
        soundsPlaying.add(soundClip);
        soundClip.play();
    }

    public void playSound(AudioClip soundClip, double x, double y, boolean overPlay) {
        double distance = Math.sqrt(Math.pow((receiver.getX() - x), 2) + Math.pow((receiver.getY()- y), 2));
        if (distance > audibleRadius) return;

        double volume = 1 - distance / audibleRadius;
        playSound(soundClip, volume, overPlay);
    }

    public void playSound(AudioClip soundClip, double x, double y, double volumeFactor, boolean overPlay) {
        double distance = Math.sqrt(Math.pow((receiver.getX() - x), 2) + Math.pow((receiver.getY()- y), 2));
        if (distance > audibleRadius) return;

        double volume = 1 - distance / audibleRadius;
        playSound(soundClip, volume * volumeFactor, overPlay);
    }

    private void refreshSoundsPlaying() {
        for (AudioClip sound : soundsPlaying) {
            if (!sound.isPlaying()) {
                soundsPlaying.remove(sound);
            }
        }
    }

    private boolean soundIsPlaying(AudioClip sound) {
        refreshSoundsPlaying();
        return soundsPlaying.contains(sound);
    }

}
