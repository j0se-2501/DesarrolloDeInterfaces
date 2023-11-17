package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class Turbo extends JLabel {
	
	public final int ANCHURA_SPRITE =52*Vista.reescalador, ALTURA_SPRITE =19*Vista.reescalador;
	public boolean pulsado=false;
	ImageIcon imageIconON, imageIconOFF,imageIconPulsar;
	Image imageON, imageOFF, imagePulsar;
	Image newimgON, newimgOFF, newimgPulsar;
	
	public Turbo() {
    	imageIconON = (new ImageIcon(getClass().getResource("/spritillos/turboON.png")));
    	imageON = imageIconON.getImage(); // transform it 
    	newimgON = imageON.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIconON = new ImageIcon(newimgON);
    	imageIconOFF = (new ImageIcon(getClass().getResource("/spritillos/turboOFF.png")));
    	imageOFF = imageIconOFF.getImage(); // transform it 
    	newimgOFF = imageOFF.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIconOFF = new ImageIcon(newimgOFF);// transform it back
    	imageIconPulsar = (new ImageIcon(getClass().getResource("/spritillos/turboPULSADO.png")));
    	imagePulsar = imageIconPulsar.getImage(); // transform it 
    	newimgPulsar = imagePulsar.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	imageIconPulsar = new ImageIcon(newimgPulsar);
    	this.setIcon(imageIconPulsar);
    }
	
	public void encender(boolean encender) {
		if (encender) {
			this.setIcon(imageIconON);
			pulsado=true;
		}
		else if(!encender) {
			this.setIcon(imageIconOFF);
			pulsado=false;
		}
	}
	
	public void pulsar(boolean pulsar) {
		if (pulsar) this.setIcon(imageIconPulsar);
		
	}
	

}
