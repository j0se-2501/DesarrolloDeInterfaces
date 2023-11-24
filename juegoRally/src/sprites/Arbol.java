package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class Arbol extends JLabel {

	public int ANCHURA_SPRITE =56*Vista.reescalador;
	public int ALTURA_SPRITE =88*Vista.reescalador;
	String rutaSprite="/spritillos/arbolLeft0.png";
	ImageIcon originalIcon;
	Image image;
	ImageIcon imageIcon;
	Image newimg;
	
	public Arbol() {
    	imageIcon = (new ImageIcon(getClass().getResource(rutaSprite)));
    	image = imageIcon.getImage(); // transform it 
    	newimg = image.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);  // transform it back
    	this.setIcon(imageIcon);
    	this.setBounds(0, 0, ANCHURA_SPRITE, ALTURA_SPRITE);
    }
	
}
