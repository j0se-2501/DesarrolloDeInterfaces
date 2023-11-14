package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.Controlador;
import sprites.Car;
import sprites.Cielo;
import sprites.Fondo;
import sprites.Camino;

public class Vista extends JFrame {
	
	// Creamos una lámina para colocar encima del JFrame
    public JPanel lienzo = new JPanel();
    public JPanel juego = new JPanel();
    public Camino pathPanel = new Camino();
    public Car carPanel = new Car();
    public Cielo skyPanel = new Cielo();
    public Fondo backgroundPanel = new Fondo();
    
    public static int reescalador=4;
    
    public final int ANCHURA_JUEGO=320*reescalador;
	public final int ALTURA_JUEGO=240*reescalador;
	
	
     
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
         //lienzo.setBounds(0,0,320, 240);
         //lienzo.setBackground(Color.black);
         
   // Agregamos las etiquetas al norte y al sur de la lamina
            
     }
     
     private void configurarJuego() {
    	 
    	 
         
         // Le damos a la lamina una distribución de tipo BorderLayout.
         juego.setLayout(null);
         juego.setBounds(0,0,ANCHURA_JUEGO, ALTURA_JUEGO);
         juego.setBackground(Color.black);
         lienzo.add(juego);
         
   // Agregamos las etiquetas al norte y al sur de la lamina
            
     }
     
     private void configurarCamino() {
    	 
    	 pathPanel.setLayout(null);
    	 pathPanel.setBounds(((ANCHURA_JUEGO/2)-(pathPanel.ANCHURA_SPRITE/2)), ALTURA_JUEGO-pathPanel.ALTURA_SPRITE, pathPanel.ANCHURA_SPRITE, pathPanel.ALTURA_SPRITE);
    	 pathPanel.setVisible(true);
    	 juego.add(pathPanel);
    	 
     }
     
     private void configurarCoche() {
    	 
    	 carPanel.setLayout(null);
    	 carPanel.setBounds(((ANCHURA_JUEGO/2)-(carPanel.ANCHURA_SPRITE/2)), ALTURA_JUEGO-carPanel.ALTURA_SPRITE, carPanel.ANCHURA_SPRITE, carPanel.ALTURA_SPRITE);
    	 carPanel.setVisible(true);
    	 juego.add(carPanel);
    	 
     }
     
     private void configurarCielo() {
    	 
    	 skyPanel.setLayout(null);
    	 skyPanel.setBounds(((ANCHURA_JUEGO/2)-(skyPanel.ANCHURA_SPRITE/2)), 0, skyPanel.ANCHURA_SPRITE, skyPanel.ALTURA_SPRITE);
    	 skyPanel.setVisible(true);
    	 juego.add(skyPanel);
    	 
     }
     
     private void configurarFondo() {

    	 backgroundPanel.setLayout(null);
    	 backgroundPanel.setBounds(((ANCHURA_JUEGO/2)-(backgroundPanel.ANCHURA_SPRITE/2)), ALTURA_JUEGO-pathPanel.ALTURA_SPRITE-backgroundPanel.ALTURA_SPRITE, backgroundPanel.ANCHURA_SPRITE, backgroundPanel.ALTURA_SPRITE);
    	 backgroundPanel.setVisible(true);
    	 juego.add(backgroundPanel);
    	 
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
            this.setSize(ANCHURA_JUEGO+16, ALTURA_JUEGO+39);
             
            // Agregamos un tículo
            this.setTitle("Rally Game");
              
            // Lo centramos en pantalla
            this.setLocationRelativeTo(null);
              
            /* Le decimos que no se puede redimensionar*/
            this.setResizable(false);
              
            // Le decimos que al cerrar la ventana, acabe el programa
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
            // Agregamos una lámina a la ventana
            this.add(lienzo);
             
            // llamamos al método que configura la lamina fondo
            // y la lamina de los botones
            configurarLienzo();
            
            configurarJuego();
            configurarFondo();
            configurarCoche();
            configurarCamino();
            configurarCielo();
        
            ejecutar();
        }  
     

}
