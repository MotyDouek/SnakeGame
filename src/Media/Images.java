package Media;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public BufferedImage[] snakeParts;
	public BufferedImage[] apples;
	
	public Images() {
		snakeParts = new BufferedImage[5];
		apples = new BufferedImage[1];
		
		try {
			
			snakeParts[0] = ImageIO.read(getClass().getResourceAsStream("/Snakes_Parts/right.png"));
			snakeParts[1] = ImageIO.read(getClass().getResourceAsStream("/Snakes_Parts/left.png"));
			snakeParts[2] = ImageIO.read(getClass().getResourceAsStream("/Snakes_Parts/up.png"));
			snakeParts[3] = ImageIO.read(getClass().getResourceAsStream("/Snakes_Parts/down.png"));
			snakeParts[4] = ImageIO.read(getClass().getResourceAsStream("/Snakes_Parts/body.png"));
			
			apples[0] = ImageIO.read(getClass().getResourceAsStream("/apple.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
