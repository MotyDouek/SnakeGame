package GameState;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import Entities.Snake;
import Main.GamePanel;
import Media.Background;
import Media.Sounds;
import Objects.Apple;
import Objects.Score;
import physics.Collision;

public class SnakeGame extends GameState implements ActionListener {
	
	// Declarations
	
	//background and fonts
	private Background bg;
	
	// units settings
	public static int UNIT_SIZE = 25;
	public static int GAME_UNITS = (GamePanel.WIDTH * GamePanel.HEIGHT)/UNIT_SIZE;
	
	// game settings
	boolean SnakeGameRunning = false;
	Snake snake;
	Timer timer;
	public static final int DELAY = 75; //How fast the game will be. the higher, the slower.
	
	//apple
	Apple apples;
	Random random = new Random();
	
	//score
	public static Score score;
	
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
		apples = new Apple();
		score = new Score();
		
		//start time
		timer = new Timer(DELAY,this);
		timer.start();
	}

	@Override
	public void init() {
		snake.init();
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g) {
		// drawing the background
		bg.draw(g);
		
		if (SnakeGameRunning) {
			
			//draw the net
			/**
			g.setColor(Color.BLACK);
			for (int i=0; i<GamePanel.HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, GamePanel.HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, GamePanel.WIDTH, i*UNIT_SIZE);
			}
			**/
			
			snake.draw(g);
			apples.draw(g);
			score.draw(g);
	
		} else if(!SnakeGameRunning) {
			gsm.states.push(new GameOverState(gsm));
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
		
		//check if snake eat apple
		if(Collision.eatApple(snake, apples)) {
			snake.addBodyPart();
			apples.newAllpe();
			score.addToScore();
			Sounds.appleBiteSound();
		}
		
		//check self collision
		if(Collision.selfCollisions(snake)) {
			SnakeGameRunning = false;
		}
		
		//check border collision
		if(Collision.borderCollisions(snake)) {
			SnakeGameRunning = false;
		}
	}

}
