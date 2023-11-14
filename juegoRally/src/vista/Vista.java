package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.Controlador;
import sprites.Car;

public class Vista extends JFrame {
	
	// Creamos una lámina para colocar encima del JFrame
    public JPanel lienzo = new JPanel(); 
    public JPanel pathPanel = new JPanel();
    public Car carPanel = new Car();
    public JPanel skyPanel = new JPanel();
    public JPanel backgroundPanel = new JPanel();
     
    // Creamos los controles que tendrá nuestra lámina
     
    /**
     * EL CONSTRUCTOR CREA LA VENTANA, LE DA UNAS PROPIEDADES
     * Y ADEMÁS EN EL, SE INDICA QUE SE LE AGREGUE UN JPANEL,
     * UNA LAMINA PARA PODER AGREGAR
     * LOS CONTROLES NECESARIOS
     */
     
     private void configurarLienzo() {
         
         // Le damos a la lamina una distribución de tipo BorderLayout.
         lienzo.setLayout(null);
         
   // Agregamos las etiquetas al norte y al sur de la lamina
            
     }
     
     private void configurarCamino() {
    	 
    	 
    	 
     }
     
     private void configurarCoche() {
    	 
    	 lienzo.add(carPanel);
    	 
     }
     
     private void configurarCielo() {
    	 
     }
     
     private void configurarFondo() {

     }
     //Conectar Vista con Controlador
     
     // Creamos una instancia de nuestra clase controlador
        private Controlador ejecutarAcciones;
         
        /**
        * ESTE MÉTODO EJECUTA LAS ACCIONES DEL CONTROLADOR UNA VEZ
        * QUE ES LLAMADO DESDE EL CONSTRUCTOR DE ESTA CLASE
        */
        private void ejecutar() {
            ejecutarAcciones = new Controlador(this);
            ejecutarAcciones.escucharEventos();
        }
        
        public Vista() {
            
            // Le damos un tamaño a la ventana
            this.setSize(320, 240);
             
            // Agregamos un tículo
            this.setTitle("Rally Game");
              
            // Lo centramos en pantalla
            this.setLocationRelativeTo(null);
              
            /* Le decimos que no se puede redimensionar*/
            this.setResizable(false);
              
            // Le decimos que al cerrar la ventana, acabe el programa
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
            // Agregamos una lámina a la ventana
            this.getContentPane().add(lienzo);
             
            // llamamos al método que configura la lamina fondo
            // y la lamina de los botones
            configurarLienzo();
            configurarCoche();
            //configurarLaminaBotones();
            ejecutar();
        }  
     

}
