package GameState;

import java.util.Stack;

public class GameStateManager {
	
	// Declarations
		// an array list that contains the different game states.
		public Stack<GameState> states;
		
		public GameStateManager() {
			states = new Stack<GameState>();
			states.push(new MenuState(this));
		}
		
		public void update() {
			states.peek().update();
		}
		
		public void draw(java.awt.Graphics2D g) {
			states.peek().draw(g);
		}
		

		public void keyPressed(int k) {
			states.peek().keyPressed(k);
		}
	
		public void keyReleased(int k) {
			states.peek().keyReleased(k);
		}

}
