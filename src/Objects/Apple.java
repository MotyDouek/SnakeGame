package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import GameState.SnakeGame;
import Main.GamePanel;
import Media.Images;

public class Apple extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	public int x, y;
	Random random = new Random();
	Images appleImage = new Images();
	
	public Apple() {
		x = random.nextInt((int)(GamePanel.WIDTH / SnakeGame.UNIT_SIZE))*SnakeGame.UNIT_SIZE;
		y = random.nextInt((int)(GamePanel.HEIGHT / SnakeGame.UNIT_SIZE))*SnakeGame.UNIT_SIZE;
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(appleImage.apples[0], x, y, SnakeGame.UNIT_SIZE, SnakeGame.UNIT_SIZE, null);
		//g.setColor(Color.BLACK);
		//g.fillOval(x, y, SnakeGame.UNIT_SIZE, SnakeGame.UNIT_SIZE);
	}
	
	public void newAllpe() {
		this.x = random.nextInt((int)(GamePanel.WIDTH / SnakeGame.UNIT_SIZE))*SnakeGame.UNIT_SIZE;
		this.y = random.nextInt((int)(GamePanel.HEIGHT / SnakeGame.UNIT_SIZE))*SnakeGame.UNIT_SIZE;
	}
	
}
