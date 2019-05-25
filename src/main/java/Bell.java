import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Bell extends Thread{
    private Clip clip;
    private AudioInputStream audioInputStream;

    public Bell(int index) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        // index is order of alarm
        String fileName = "/sounds/Alarm" + Integer.toString(index) + ".wav";
        InputStream audioSrc = getClass().getResourceAsStream(fileName);
        InputStream bufferedIn = new BufferedInputStream(audioSrc);
        try{
            // Make Jar File
            audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
        }catch(Exception e){
            // IDE Test
            audioInputStream = AudioSystem.getAudioInputStream(new File(getClass().getResource("").getPath()+"sounds/Alarm"+index+".wav"));
        }


        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {
        clip.loop(1);
        this.run();
    }

    public void pause() {
        clip.stop();
    }
    public void run() {
        clip.start();
    }

    public boolean isRunning() {return clip.isActive();}
}