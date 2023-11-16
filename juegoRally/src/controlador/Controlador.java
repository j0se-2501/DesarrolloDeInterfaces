package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.*;

public class Controlador implements ActionListener, KeyListener{
	
	// Creamos una variable de tipo PintarVentana
    Vista vista;
     
    /**
     * EL MÉTODO CONSTRUCTOR RECIBIRÁ POR PARÁMETRO UN
     * OBJETO DE TIPO PINTAR VENTANA Y A ESTE OBJETO
     */
     
    public Controlador(Vista vista) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por parámetro
        // en el constructor de esta clase
        this.vista=vista;
    }
     
    /**
     * ESTE MÉTODO PONE A LA ESCUCHA DE LOS EVENTOS
     * DE CLIC DE RATON A CADA UNO DE LOS BOTONES
     * DE LA VENTANA CREADA EN EL PAQUETE VISTA
     */
    public void escucharEventos() {
        vista.addKeyListener(this);
    }
     
    /**
     * ESTE MÉTODO SE ENCARGA DE EJECUTAR LAS ACCIONES
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
          
      
    	
    }
    
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
        	vista.carPanel.detenerIzquierda();
        }
        if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
        	vista.carPanel.detenerDerecha();
        }
    }

    @Override
	public void keyTyped(KeyEvent e) {
    	if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
            vista.carPanel.girarIzquierda();
        }
    	if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
        	vista.carPanel.girarDerecha();
        }
    	if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
            vista.carPanel.acelerar();
        }
		
	}


	public void update() {

	//vista.carPanel.update();

	}

	

}
