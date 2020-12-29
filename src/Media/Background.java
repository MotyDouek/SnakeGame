package Media;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Background {
	
		//declarations
		private BufferedImage image;
		
		private double x;
		private double y;
		private double dx;
		private double dy;
		
		public double moveScale;
		
		public Background(String s, double ms) {
			
			try {
				image = ImageIO.read(getClass().getResourceAsStream(s));
				moveScale = ms;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void setPosition(double x, double y) {
			this.x = (x * moveScale) % GamePanel.WIDTH;
			this.y = (y * moveScale) % GamePanel.HEIGHT;
		}
		
		public void setVector(double dx, double dy) {
			this.dx = dx;
			this.dy = dy;
		}
		
		public void update(boolean isMoving) {
			if (isMoving) {
				x += dx;
				y += dy;
			}
		}
		
		public void draw(Graphics2D g) {
			

			g.drawImage(image, (int)x, (int)y, null);
			if(x < 0) {
				g.drawImage(image, (int)x + GamePanel.WIDTH, (int)y, null);
			}
			
			if(x > 0) {
				g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
			}
			
		}

}
