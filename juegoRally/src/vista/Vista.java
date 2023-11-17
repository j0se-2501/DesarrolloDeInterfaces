package vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import controlador.Controlador;
import controlador.HiloJuego;
import sprites.Car;
import sprites.Cielo;
import sprites.Fondo;
import sprites.FontNumbers;
import sprites.FontSpeed;
import sprites.Max;
import sprites.Turbo;
import sprites.Camino;

public class Vista extends JFrame {
	
	public static int reescalador=4;
	
	// Creamos una lámina para colocar encima del JFrame
    public JPanel lienzo = new JPanel();
    public JPanel juego = new JPanel();
    public Camino pathPanel = new Camino();
    public Car carPanel = new Car();
    public Cielo skyPanel = new Cielo();
    public Fondo backgroundPanel = new Fondo();
    public FontSpeed velocimetroSpeed = new FontSpeed();
    public FontNumbers velocimetro1 = new FontNumbers();
    public FontNumbers velocimetro2 = new FontNumbers();
    public FontNumbers velocimetro3 = new FontNumbers();
    public FontNumbers[] velocimetroDigitos = {velocimetro1, velocimetro2, velocimetro3};
    public Turbo turbo = new Turbo();
    public Max max = new Max();
    
    
    public final static int ANCHURA_JUEGO=320*reescalador;
	public final static int ALTURA_JUEGO=240*reescalador;
	
	
     
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
     
     private void configurarHUD() {
    	 
    	 velocimetroSpeed.setLayout(null);
    	 velocimetroSpeed.setBounds(4*reescalador, 8*reescalador, velocimetroSpeed.ANCHURA_SPRITE, velocimetroSpeed.ALTURA_SPRITE);
    	 velocimetroSpeed.setVisible(true);
    	 juego.add(velocimetroSpeed);
    	 
    	 for (int i=0; i<3; i++) {
    	 
    	 velocimetroDigitos[i].setLayout(null);
    	 velocimetroDigitos[i].setBounds(velocimetroSpeed.ANCHURA_SPRITE+(9*reescalador*(i+1)), 8*reescalador, velocimetroDigitos[i].ANCHURA_SPRITE, velocimetroDigitos[i].ALTURA_SPRITE);
    	 if (i!=0) velocimetroDigitos[i].setVisible(false);
    	 else velocimetroDigitos[i].setVisible(true);
    	 juego.add(velocimetroDigitos[i]);
    	 
    	 turbo.setLayout(null);
    	 turbo.setBounds(((ANCHURA_JUEGO/2)-(turbo.ANCHURA_SPRITE/2))-4*reescalador, 4*reescalador, turbo.ANCHURA_SPRITE, turbo.ALTURA_SPRITE);
    	 turbo.setVisible(true);
    	 juego.add(turbo);
    	 
    	 max.setLayout(null);
    	 max.setBounds(velocimetroSpeed.ANCHURA_SPRITE+(9*reescalador), 8*reescalador, max.ANCHURA_SPRITE, max.ALTURA_SPRITE);
    	 max.setVisible(false);
    	 juego.add(max);
    	 }
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
            HiloJuego juego = new HiloJuego(ejecutarAcciones);
            Thread HiloJuego = new Thread(juego);
			//Llamada al hilo para ejecutar.
			HiloJuego.start();
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
            
            this.setFocusable(true);
              
            // Le decimos que al cerrar la ventana, acabe el programa
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
            // Agregamos una lámina a la ventana
            this.add(lienzo);
             
            // llamamos al método que configura la lamina fondo
            // y la lamina de los botones
            configurarLienzo();
            
            configurarJuego();
            configurarHUD();
            configurarFondo();
            configurarCoche();
            configurarCamino();
            configurarCielo();
            
           
        
            ejecutar();
        }  
     

}
