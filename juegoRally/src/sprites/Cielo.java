package sprites;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.Vista;

public class Cielo extends JLabel {
	
	//El primer parámetro sera nuestro objeto de tipo ImageIcon, contiene la imagen que vamos a agregar.
			//El segundo y tercer parámetro serán dos valores enteros que equivalen a la posición en el eje x,y.
			//El cuarto y quinto parámetro serán las dimensiones que tendrá nuestra imagen, para este ejemplo las dimensiones sera iguales a las dimensiones de nuestro JPanel de esta manera garantizamos que la imagen tenga el mismo tamaño de nuestra ventana JFrame.
			//El ultimo parámetro solamente pasamos un valor null 
	
	
			public final int ANCHURA_SPRITE =320*Vista.reescalador;
			public final int ALTURA_SPRITE =138*Vista.reescalador;
			
			public Cielo() {
		    	ImageIcon imageIcon = (new ImageIcon(getClass().getResource("/spritillos/cielo.png")));
		    	Image image = imageIcon.getImage(); // transform it 
		    	Image newimg = image.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
		    	imageIcon = new ImageIcon(newimg);  // transform it back
		    	this.setIcon(imageIcon);
		    	this.setBounds(0, 0, ANCHURA_SPRITE, ALTURA_SPRITE);
		    }
		    
		

}