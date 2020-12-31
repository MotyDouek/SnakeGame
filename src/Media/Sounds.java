package Media;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {
	
	public static Clip arcadeClip = null;
	
	public static void failSound () {
	
		File file = new File("Resources/Failing_Sound.wav");
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip failingClip = AudioSystem.getClip();
			failingClip.open(audioStream);
			failingClip.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void startArcadeSound () {
		
		try {
			File file2 = new File("Resources/Stage_sound.wav");
			AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
			arcadeClip = AudioSystem.getClip();
			arcadeClip.open(audioStream2);
			
			arcadeClip.start();
			arcadeClip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void appleBiteSound() {
		File file3 = new File("Resources/Apple_bite.wav");
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file3);
			Clip failingClip = AudioSystem.getClip();
			failingClip.open(audioStream);
			failingClip.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeArcadeSound () {
		arcadeClip.close();
	}

}
