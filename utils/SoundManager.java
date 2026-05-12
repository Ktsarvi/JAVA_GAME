package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundManager {
    private Clip backgroundMusic;

    public void playMusic(String fileName) {
        try {
            InputStream is = getClass().getResourceAsStream("/main/" + fileName);

            if (is == null) {
                System.err.println("Error: Could not find " + fileName + " in /main/");
                return;
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));

            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(ais);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundMusic.start();

        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio format: " + fileName);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }
}