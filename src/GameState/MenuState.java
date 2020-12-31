package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Media.Background;
import Media.Sounds;

public class MenuState extends GameState {
	private Background bg;
	
	private String[] options = {"Start", "Help", "Quit"};
	private int currentSelection = 0;
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			bg = new Background("/MenuBackground.jpg", 1);
			bg.setVector(-0.1, 0);
			
			Sounds.startArcadeSound();
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 40);
			font = new Font("Arial", Font.PLAIN, 30);
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
		bg.update(true);
	}

	@Override
	public void draw(Graphics2D g) {
		// draw bg
		bg.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Moty`s Snake Game", 110, 70);
		
		// draw menu options
		g.setFont(font);
		for(int i=0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 270, 140 + i * 40);
		}
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_DOWN) {
			currentSelection++;
			if (currentSelection >= options.length) {
				currentSelection = 0;
			}
		} else if (k == KeyEvent.VK_UP) {
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		
		if (k == KeyEvent.VK_ENTER) {
			if (currentSelection == 0) {
				Sounds.closeArcadeSound();
				gsm.states.push(new SnakeGame(gsm));
			} else if (currentSelection == 1) {
				// help
			} else if (currentSelection== 2) {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		
	}

}
