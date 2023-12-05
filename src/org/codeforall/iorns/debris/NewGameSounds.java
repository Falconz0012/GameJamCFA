package org.codeforall.iorns.debris;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class NewGameSounds {
    private Clip clip;
    private URL soundURL;
    private String string;
    public NewGameSounds(String string) {
        this.string = string;
        initClip(string);
    }
    public void play() {
        this.clip.start();
    }
    private void initClip(String string) {
        this.soundURL = NewGameSounds.class.getResource(string);
        try {
            if (this.soundURL == null) {
                string = string.substring(1);
                File var3 = new File(string);
                this.soundURL = var3.toURI().toURL();
            }
            AudioInputStream audio = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip = AudioSystem.getClip();
            this.clip.open(audio);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException var4) {
            System.out.println(var4.getMessage());
        }
    }
}












