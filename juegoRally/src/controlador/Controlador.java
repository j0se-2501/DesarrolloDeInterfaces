package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import vista.*;

public class Controlador implements ActionListener {
	
	// Creamos una variable de tipo PintarVentana
    Vista vista;
    public static hiloJuego juego = new  hiloJuego();
    int FPS = 60;
     
    /**
     * EL MÉTODO CONSTRUCTOR RECIBIRÁ POR PARÁMETRO UN
     * OBJETO DE TIPO PINTAR VENTANA Y A ESTE OBJETO
     */
     
    public Controlador(Vista vDesactivar) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por parámetro
        // en el constructor de esta clase
        this.vista=vDesactivar;
        //this.juego=new Thread(this);
    }
     
    /**
     * ESTE MÉTODO PONE A LA ESCUCHA DE LOS EVENTOS
     * DE CLIC DE RATON A CADA UNO DE LOS BOTONES
     * DE LA VENTANA CREADA EN EL PAQUETE VISTA
     */
    public void escucharEventos() {
         
    	
    }
     
    /**
     * ESTE MÉTODO SE ENCARGA DE EJECUTAR LAS ACCIONES
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
          
      
    	
    }
    
    public void keyPressed(KeyEvent e) {
        // Verifica si la tecla presionada es la "A"
        if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
            // Realiza las acciones que desees cuando se presiona la tecla "A"
        	//Thread girarIzquierda = new Thread(vista.carPanel);
			//Llamada al hilo para ejecutar.
			//girarIzquierda.start();
        }
    }

	


	public void update() {

	//vista.carPanel.update();

	}

}
