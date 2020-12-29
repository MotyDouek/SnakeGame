package Entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import GameState.SnakeGame;

public class Snake {
	
	//settings
	final int x[] = new int[SnakeGame.GAME_UNITS];
	final int y[] = new int[SnakeGame.GAME_UNITS];
	private int bodyParts = 6;
	char direction = 'R'; //snake starts by moving right
	
	public Snake() {
	}
	
	public void init() {
	}
	
	public void move () {
		for (int i = bodyParts; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch (direction) {
		case 'U':
			y[0] = y[0] - SnakeGame.UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + SnakeGame.UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - SnakeGame.UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + SnakeGame.UNIT_SIZE;
			break;
		}
		
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g) {
		//draws the snake
		for (int i =0; i<bodyParts; i++) {
			if (i==0) { //head of the snake
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], SnakeGame.UNIT_SIZE, SnakeGame.UNIT_SIZE);
			}
			else { //body parts
				g.setColor(new Color(45,180,0));
				g.fillRect(x[i], y[i], SnakeGame.UNIT_SIZE, SnakeGame.UNIT_SIZE);
			}
		}
	}
	
	public void keyPressed(int k) {
		switch (k) {
		case KeyEvent.VK_LEFT:
			if (direction != 'R') { //makes sure you can`t go inside yourself
				direction = 'L';
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (direction != 'L') { //makes sure you can`t go inside yourself
				direction = 'R';
			}
			break;
		case KeyEvent.VK_UP:
			if (direction != 'D') { //makes sure you can`t go inside yourself
				direction = 'U';
			}
			break;		
		case KeyEvent.VK_DOWN:
			if (direction != 'U') { //makes sure you can`t go inside yourself
				direction = 'D';
			}
			break;
		}
	}
	
	public void keyReleased(int k) {
	}

}
