package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class FontSpeed extends JLabel {
	
	public final int ANCHURA_SPRITE =63*Vista.reescalador;
	public final int ALTURA_SPRITE =11*Vista.reescalador;

	public FontSpeed() {
    	ImageIcon imageIcon = (new ImageIcon(getClass().getResource("/spritillos/fontSpeed.png")));
    	Image image = imageIcon.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);  // transform it back
    	this.setIcon(imageIcon);
    	this.setBounds(2, 2, ANCHURA_SPRITE, ALTURA_SPRITE);
    }
	
}
