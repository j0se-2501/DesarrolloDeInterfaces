package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class FontSpeed extends JLabel {
	
	public final int ANCHURA_SPRITE =49*Vista.reescalador;
	public final int ALTURA_SPRITE =11*Vista.reescalador;
	public final boolean turbo=false;
	ImageIcon imageIcon, imageIconTurbo;
	Image image, imageTurbo;
	Image newimg, newimgTurbo;

	public FontSpeed() {
    	imageIcon = (new ImageIcon(getClass().getResource("/spritillos/fontSpeed.png")));
    	image = imageIcon.getImage(); // transform it 
    	newimg = image.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);
    	imageIconTurbo = (new ImageIcon(getClass().getResource("/spritillos/fontSpeedTurbo.png")));
    	imageTurbo = imageIconTurbo.getImage(); // transform it 
    	newimgTurbo = imageTurbo.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIconTurbo = new ImageIcon(newimgTurbo);// transform it back
    	this.setIcon(imageIcon);
    	this.setBounds(2, 2, ANCHURA_SPRITE, ALTURA_SPRITE);
    }
	
	public void turbo (boolean turbo) {
		
		if (turbo) this.setIcon(imageIconTurbo);
		else this.setIcon(imageIcon);
		
	}
	
}
