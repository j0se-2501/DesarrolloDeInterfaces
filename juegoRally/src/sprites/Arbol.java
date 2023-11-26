package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Vista;

public class Arbol extends JLabel {

	public int ANCHURA_SPRITE =56*Vista.reescalador;
	public int ALTURA_SPRITE =88*Vista.reescalador;
	
	int numeroSprite=0;
	String rutaSprite="/spritillos/arbolLeft"+numeroSprite+".png";
	ImageIcon originalIcon;
	Image image;
	ImageIcon imageIcon;
	Image newimg;
	Vista vista;
	
	public Arbol(int numeroSprite, Vista vista) {
		this.numeroSprite = numeroSprite;
		this.vista = vista;
		switch (numeroSprite) { 
	    case 0:
	    	this.ANCHURA_SPRITE =56*Vista.reescalador;
	    	this.ALTURA_SPRITE =88*Vista.reescalador;
	     break;
	    case 3:
	    	this.ANCHURA_SPRITE =50*Vista.reescalador;
	    	this.ALTURA_SPRITE =80*Vista.reescalador;
		 break;
	    case 6:
	    	this.ANCHURA_SPRITE =46*Vista.reescalador;
	    	this.ALTURA_SPRITE =72*Vista.reescalador;
		 break;
	    case 9:
	    	this.ANCHURA_SPRITE =40*Vista.reescalador;
	    	this.ALTURA_SPRITE =64*Vista.reescalador;
		 break;
	    case 12:
	    	this.ANCHURA_SPRITE =34*Vista.reescalador;
	    	this.ALTURA_SPRITE =54*Vista.reescalador;
		 break;
	    case 15:
	    	this.ANCHURA_SPRITE =30*Vista.reescalador;
	    	this.ALTURA_SPRITE =48*Vista.reescalador;
		 break;
	    case 16:
	    	this.ANCHURA_SPRITE =28*Vista.reescalador;
	    	this.ALTURA_SPRITE =44*Vista.reescalador;
		 break;
	    case 17:
	    	this.ANCHURA_SPRITE =18*Vista.reescalador;
	    	this.ALTURA_SPRITE =29*Vista.reescalador;
		 break;
	    case 18:
	    	this.ANCHURA_SPRITE =14*Vista.reescalador;
	    	this.ALTURA_SPRITE =22*Vista.reescalador;
		 break;
	    case 19:
	    	this.ANCHURA_SPRITE =11*Vista.reescalador;
	    	this.ALTURA_SPRITE =17*Vista.reescalador;
		 break;
	    case 20:
	    	this.ANCHURA_SPRITE =9*Vista.reescalador;
	    	this.ALTURA_SPRITE =14*Vista.reescalador;
		 break;
	    case 21:
	    	this.ANCHURA_SPRITE =8*Vista.reescalador;
	    	this.ALTURA_SPRITE =12*Vista.reescalador;
		 break;
	    case 22:
	    	this.ANCHURA_SPRITE =7*Vista.reescalador;
	    	this.ALTURA_SPRITE =11*Vista.reescalador;
		 break;
	    default:
	    	this.ANCHURA_SPRITE =56*Vista.reescalador;
	    	this.ALTURA_SPRITE =88*Vista.reescalador;
	  }
		
		this.rutaSprite="/spritillos/arbolLeft"+this.numeroSprite+".png";
    	this.imageIcon = (new ImageIcon(getClass().getResource(rutaSprite)));
    	this.image = this.imageIcon.getImage(); // transform it 
    	this.newimg = this.image.getScaledInstance(this.ANCHURA_SPRITE, this.ALTURA_SPRITE,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
    	this.imageIcon = new ImageIcon(this.newimg);  // transform it back
    	this.setIcon(imageIcon);
    }
	
	public void moverArboles(int numeroSprite) {
		switch(numeroSprite) {
	       case 0:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>-1&&i<5) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   
	    	   break;
	       case 1:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>4&&i<10) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   break;
	       case 2:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>9&&i<15) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   break;
	       case 3:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>14&&i<20) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   break;
	      
	       case 4:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>-1&&i<5) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   
	    	   break;
	       case 5:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>4&&i<10) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   break;
	       case 6:
	    	   for (int i = 0; i<20; i++) {
	    		   
	    		   if (i>9&&i<15) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   break;
	       case 7:
	    	   for (int i = 0; i<20; i++) {
	    		  
	    		   if (i>14&&i<20) vista.listaArbolesLeft.get(i).setVisible(true);
	    		   else vista.listaArbolesLeft.get(i).setVisible(false);
	    	   }
	    	   break;
	       }
	}
	
}
