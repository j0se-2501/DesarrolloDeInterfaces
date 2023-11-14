package sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import vista.Vista;

public class Cielo extends JPanel {
	
	//El primer parámetro sera nuestro objeto de tipo ImageIcon, contiene la imagen que vamos a agregar.
			//El segundo y tercer parámetro serán dos valores enteros que equivalen a la posición en el eje x,y.
			//El cuarto y quinto parámetro serán las dimensiones que tendrá nuestra imagen, para este ejemplo las dimensiones sera iguales a las dimensiones de nuestro JPanel de esta manera garantizamos que la imagen tenga el mismo tamaño de nuestra ventana JFrame.
			//El ultimo parámetro solamente pasamos un valor null 
	
	
			public final int ANCHURA_SPRITE =320*Vista.reescalador;
			public final int ALTURA_SPRITE =138*Vista.reescalador;

		    @Override
		    public void paint(Graphics g){
		        
		        ImageIcon icon = new ImageIcon(getClass().getResource("/spritillos/cielo.png"));
		        g.drawImage(icon.getImage(), 0, 0, ANCHURA_SPRITE, ALTURA_SPRITE, null);
		        setOpaque(false);
		        super.paintChildren(g);
		    }

}