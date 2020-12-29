package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Entities.Snake;
import Main.GamePanel;
import Media.Background;

public class SnakeGame extends GameState implements ActionListener {
	
	// Declarations
	
	//background and fonts
	private Background bg;
	
	// units settings
	public static int UNIT_SIZE = 25;
	public static int GAME_UNITS = (GamePanel.WIDTH * GamePanel.SCALE * GamePanel.HEIGHT * GamePanel.SCALE)/UNIT_SIZE;
	
	// game settings
	boolean SnakeGameRunning = false;
	Snake snake;
	
	//te
	Timer timer;
	public static final int DELAY = 75; //How fast the game will be. the higher, the slower.
	
	public SnakeGame(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {
			bg = new Background("/SnakeBackground.jpg", 0);
			bg.setVector(-0.1, 0);
			startGame();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startGame () {
		SnakeGameRunning = true;
		snake = new Snake();
		//te
		timer = new Timer(DELAY,this);
		timer.start();
	}

	@Override
	public void init() {
		snake.init();
	}

	@Override
	public void update() {
		snake.update();
	}

	@Override
	public void draw(Graphics2D g) {
		// drawing the background
		bg.draw(g);
		
		if (SnakeGameRunning) {
			
			//draw the net
			g.setColor(Color.BLACK);
			for (int i=0; i<GamePanel.HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, GamePanel.HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, GamePanel.WIDTH, i*UNIT_SIZE);
			}
			
			snake.draw(g);
	
		} else if(!SnakeGameRunning) {
			//gameOver(g);
		}
	}

	@Override
	public void keyPressed(int k) {
		snake.keyPressed(k);
	}

	@Override
	public void keyReleased(int k) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		snake.move();
	}

}
