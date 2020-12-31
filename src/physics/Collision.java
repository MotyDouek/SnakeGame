package physics;

import Entities.Snake;
import Main.GamePanel;
import Objects.Apple;

public class Collision {
		
	public static boolean eatApple(Snake snake, Apple apple) {
		return((snake.x[0] == apple.x) && snake.y[0] == apple.y);
	}
	
	public static boolean selfCollisions(Snake snake) {
		for(int i = snake.getBodyParts(); i > 0; i--) {
			if((snake.x[0] == snake.x[i]) && (snake.y[0] == snake.y[i])){
				return true;
			}
		}
		return false;
	}
	
	public static boolean borderCollisions(Snake snake) {
		//check if head touches left border
		if (snake.x[0] < 0) {
			return true;
		}
		
		//check if head touches right border
		if (snake.x[0] > GamePanel.WIDTH) {
			return true;
		}
		
		//check if head touches top border
		if (snake.y[0] < 0) {
			return true;
		}
		
		//check if head touches bottom border
		if (snake.y[0] > GamePanel.HEIGHT) {
			return true;
		}
		
		return false;
	}

}
