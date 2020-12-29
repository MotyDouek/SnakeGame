package Main;

import javax.swing.JFrame;

public class Game {
	
public static void main (String[] args) {
		
		// JFrame settings
		JFrame window = new JFrame("Moty`s Snake Game");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
	}

}
