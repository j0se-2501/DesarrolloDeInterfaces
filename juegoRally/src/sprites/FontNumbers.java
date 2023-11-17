package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class FontNumbers extends JLabel  {
	
	public final int ANCHURA_SPRITE =7*Vista.reescalador;
	public final int ALTURA_SPRITE =11*Vista.reescalador;
	String rutaSprite="/spritillos/font0.png";
	ImageIcon originalIcon, imageIconTurbo2, imageIconTurbo0;
	Image image, imageTurbo0, imageTurbo2, newimgTurbo0, newimgTurbo2;
	
	public static final int FONT_NUMS = 10;
	
	public final ImageIcon[] fontNumsImageIcons = new ImageIcon[FONT_NUMS];
	
	public FontNumbers() {
		
		for (int i = 0; i < FONT_NUMS; i++) {
            originalIcon = new ImageIcon(getClass().getResource("/spritillos/font" + i + ".png"));
            image = originalIcon.getImage().getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE, Image.SCALE_FAST);
            fontNumsImageIcons[i] = new ImageIcon(image);
        }
		imageIconTurbo2 = (new ImageIcon(getClass().getResource("/spritillos/font2Turbo.png")));
		imageIconTurbo0 = (new ImageIcon(getClass().getResource("/spritillos/font0Turbo.png")));
    	imageTurbo2 = imageIconTurbo2.getImage();
    	imageTurbo0 = imageIconTurbo0.getImage();// transform it 
    	newimgTurbo2 = imageTurbo2.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST);
    	newimgTurbo0 = imageTurbo0.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIconTurbo2 = new ImageIcon(newimgTurbo2);
    	imageIconTurbo0 = new ImageIcon(newimgTurbo0);// transform it back
		//Vista vista = new Vista();
    	  // transform it back
    	this.setIcon(fontNumsImageIcons[0]);
    	//this.setBounds(((vista.ANCHURA_JUEGO/2)-(this.ANCHURA_SPRITE/2)), vista.ALTURA_JUEGO-this.ALTURA_SPRITE, this.ANCHURA_SPRITE, this.ALTURA_SPRITE);
    }
	
	public void cambiarNumero (int numeroSprite) {
		this.setIcon(fontNumsImageIcons[numeroSprite]);
	}
	
	public void turbo (boolean turbo, int n) {
		if (turbo &&n==0) {
			this.setIcon(imageIconTurbo0);
		}
		else if (turbo &&n==2) {
			this.setIcon(imageIconTurbo2);
		}
		if (!turbo) {
			this.setIcon(null);
		}
		
	}

}
