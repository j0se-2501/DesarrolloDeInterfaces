package ej03;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		
		try {
	    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
	    	
		// Creamos una instancia de la clase PintarVentana
        Vista ventanaPintada=new Vista();
        
        // Hacemos visible la ventana
        ventanaPintada.setVisible(true);
        
		} catch (Exception e) {
	    	e.printStackTrace();
	    }

	}

}
