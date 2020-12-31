package Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score {
	
	private int score;
	
	 public Score(){
		 this.score = 0;
	 }
	 
	 public Score(Score s) {
		 this.score = s.getScore();
	 }
	 
	 public void update() {
			
	}
	 
	 public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("Score: " + score, 230, 40);
	}
	 
	 public int getScore() {
		 return score;
	 }
	 
	 public void addToScore() {
		 this.score++;
	 }

}
