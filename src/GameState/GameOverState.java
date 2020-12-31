package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Media.Background;
import Media.Sounds;
import Objects.Score;

public class GameOverState extends GameState {
	
	private Background bg;
	private Score score;
	
	public GameOverState(GameStateManager gsm) {
		this.gsm = gsm;
		
		score = new Score(SnakeGame.score);
		
		try {
			bg = new Background("/SnakeBackground.jpg", 0);
			bg.setVector(-0.1, 0);
			Sounds.failSound();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D g) {
		//Game Over text
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		g.drawString("Game Over", 110, 200); 
		
		//draw score
		score.draw(g);
		
		//new Game
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("New Game?(Y \\ N)", 145, 250);
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_Y) {
			gsm.states.push(new SnakeGame(gsm));
		}
		
		if (k == KeyEvent.VK_N) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(int k) {
		
	}

}
