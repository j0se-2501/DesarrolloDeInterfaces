package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class Camino extends JLabel {
	
	//El primer parámetro sera nuestro objeto de tipo ImageIcon, contiene la imagen que vamos a agregar.
			//El segundo y tercer parámetro serán dos valores enteros que equivalen a la posición en el eje x,y.
			//El cuarto y quinto parámetro serán las dimensiones que tendrá nuestra imagen, para este ejemplo las dimensiones sera iguales a las dimensiones de nuestro JPanel de esta manera garantizamos que la imagen tenga el mismo tamaño de nuestra ventana JFrame.
			//El ultimo parámetro solamente pasamos un valor null 
	
	
			public final int ANCHURA_SPRITE =320*Vista.reescalador;
			public final int ALTURA_SPRITE =98*Vista.reescalador;
			String rutaSprite="/spritillos/camino0.png";
			ImageIcon originalIcon;
			Image image;
			Arbol[] arbolesLeft = new Arbol[20];
			Arbol[] arbolesRight = new Arbol[20];
			
			// Definir el número total de imágenes que tienes
		    public static final int NUM_IMAGENES = 8;

		    // Arreglo para almacenar tus ImageIcons
		    public final ImageIcon[] caminoImageIcons = new ImageIcon[NUM_IMAGENES];
		    
		    public Camino() {
				
				for (int i = 0; i < NUM_IMAGENES; i++) {
		            originalIcon = new ImageIcon(getClass().getResource("/spritillos/camino" + i + ".png"));
		            image = originalIcon.getImage().getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE, Image.SCALE_FAST);
		            caminoImageIcons[i] = new ImageIcon(image);
		        }
				//Vista vista = new Vista();
		    	  // transform it back
		    	this.setIcon(caminoImageIcons[0]);
		    	//this.setBounds(((vista.ANCHURA_JUEGO/2)-(this.ANCHURA_SPRITE/2)), vista.ALTURA_JUEGO-this.ALTURA_SPRITE, this.ANCHURA_SPRITE, this.ALTURA_SPRITE);
		    	
		    	for(int i= 0; i<20; i++) {
		    		arbolesLeft[i]=new Arbol();
		    		arbolesLeft[i].ALTURA_SPRITE=(arbolesLeft[i].ALTURA_SPRITE/i)*Vista.reescalador;
		    		arbolesLeft[i].ANCHURA_SPRITE=(arbolesLeft[i].ANCHURA_SPRITE/i)*Vista.reescalador;
		    		arbolesLeft[i].imageIcon = (new ImageIcon(getClass().getResource(rutaSprite)));
		    		arbolesLeft[i].image = arbolesLeft[i].imageIcon.getImage(); // transform it 
		    		arbolesLeft[i].newimg = image.getScaledInstance(ANCHURA_SPRITE, ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
		    		arbolesLeft[i].imageIcon = new ImageIcon(arbolesLeft[i].newimg);  // transform it back
		        	this.setIcon(arbolesLeft[i].imageIcon);
		        	this.setBounds(0, 0, ANCHURA_SPRITE, ALTURA_SPRITE);
		    	}
		    	
		    }

			public void moverCamino (int numeroSprite) {
				this.setIcon(caminoImageIcons[numeroSprite]);
		    	this.setBounds(((Vista.ANCHURA_JUEGO/2)-(this.ANCHURA_SPRITE/2)), Vista.ALTURA_JUEGO-this.ALTURA_SPRITE, this.ANCHURA_SPRITE, this.ALTURA_SPRITE);
			}

		   

}