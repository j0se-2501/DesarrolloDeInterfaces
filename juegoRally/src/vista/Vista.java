package vista;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
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
import sprites.Arbol;
import sprites.Camino;

public class Vista extends JFrame {
	
	public static int reescalador=3;
	
	// Creamos una lámina para colocar encima del JFrame
    public JPanel lienzo = new JPanel();
    public JPanel juego = new JPanel();
    public Camino pathPanel = new Camino(this);
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
    public Arbol arbolLeft0, arbolLeft1, arbolLeft2, arbolLeft3, arbolLeft4, arbolLeft5,arbolLeft6, arbolLeft7,arbolLeft8, arbolLeft9,
    			 arbolLeft10, arbolLeft11, arbolLeft12, arbolLeft13, arbolLeft14, arbolLeft15,arbolLeft16, arbolLeft17,arbolLeft18, arbolLeft19;
    public Arbol arbolRight0, arbolRight1, arbolRight2, arbolRight3, arbolRight4, arbolRight5, arbolRight6, arbolRight7, arbolRight8, arbolRight9,
    			 arbolRight10, arbolRight11, arbolRight12, arbolRight13, arbolRight14, arbolRight15, arbolRight16, arbolRight17, arbolRight18, arbolRight19;

    public ArrayList <Arbol> listaArbolesLeft = new ArrayList<Arbol>();
    public ArrayList <Arbol> listaArbolesRight = new ArrayList<Arbol>();
    
    
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
     
private void configurarArboles() {
		
	// Primer conjunto
	arbolLeft0 = new Arbol(0, this);
	arbolLeft0.setLayout(null);
	arbolLeft0.setBounds(10*reescalador, 110*reescalador, arbolLeft0.ANCHURA_SPRITE, arbolLeft0.ALTURA_SPRITE);
	arbolLeft0.setVisible(true);

	listaArbolesLeft.add(arbolLeft0);

	arbolLeft1 = new Arbol(12, this);
	arbolLeft1.setLayout(null);
	arbolLeft1.setBounds(71*reescalador, 121*reescalador, arbolLeft1.ANCHURA_SPRITE, arbolLeft1.ALTURA_SPRITE);
	arbolLeft1.setVisible(true);
	
	listaArbolesLeft.add(arbolLeft1);

	arbolLeft2 = new Arbol(17, this);
	arbolLeft2.setLayout(null);
	arbolLeft2.setBounds(108*reescalador, 133*reescalador, arbolLeft2.ANCHURA_SPRITE, arbolLeft2.ALTURA_SPRITE);
	arbolLeft2.setVisible(true);
	
	listaArbolesLeft.add(arbolLeft2);

	arbolLeft3 = new Arbol(19, this);
	arbolLeft3.setLayout(null);
	arbolLeft3.setBounds(130*reescalador, 135*reescalador, arbolLeft3.ANCHURA_SPRITE, arbolLeft3.ALTURA_SPRITE);
	arbolLeft3.setVisible(true);
	
	listaArbolesLeft.add(arbolLeft3);

	arbolLeft4 = new Arbol(22, this);
	arbolLeft4.setLayout(null);
	arbolLeft4.setBounds(146*reescalador, 135*reescalador, arbolLeft4.ANCHURA_SPRITE, arbolLeft4.ALTURA_SPRITE);
	arbolLeft4.setVisible(true);
	
	listaArbolesLeft.add(arbolLeft4);

	//////////////////////////////////

	// Segundo conjunto
	arbolLeft5 = new Arbol(0, this);
	arbolLeft5.setLayout(null);
	arbolLeft5.setBounds(-7*reescalador, 118*reescalador, arbolLeft5.ANCHURA_SPRITE, arbolLeft5.ALTURA_SPRITE);
	arbolLeft5.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft5);

	arbolLeft6 = new Arbol(9, this);
	arbolLeft6.setLayout(null);
	arbolLeft6.setBounds(55*reescalador, 117*reescalador, arbolLeft6.ANCHURA_SPRITE, arbolLeft6.ALTURA_SPRITE);
	arbolLeft6.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft6);

	arbolLeft7 = new Arbol(16, this);
	arbolLeft7.setLayout(null);
	arbolLeft7.setBounds(97*reescalador, 121*reescalador, arbolLeft7.ANCHURA_SPRITE, arbolLeft7.ALTURA_SPRITE);
	arbolLeft7.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft7);

	arbolLeft8 = new Arbol(18, this);
	arbolLeft8.setLayout(null);
	arbolLeft8.setBounds(126*reescalador, 132*reescalador, arbolLeft8.ANCHURA_SPRITE, arbolLeft8.ALTURA_SPRITE);
	arbolLeft8.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft8);

	arbolLeft9 = new Arbol(21, this);
	arbolLeft9.setLayout(null);
	arbolLeft9.setBounds(144*reescalador, 135*reescalador, arbolLeft9.ANCHURA_SPRITE, arbolLeft9.ALTURA_SPRITE);
	arbolLeft9.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft9);

	//////////////////////////////////

	// Tercer conjunto
	arbolLeft10 = new Arbol(0, this);
	arbolLeft10.setLayout(null);
	arbolLeft10.setBounds(-24*reescalador, 126*reescalador, arbolLeft10.ANCHURA_SPRITE, arbolLeft10.ALTURA_SPRITE);
	arbolLeft10.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft10);

	arbolLeft11 = new Arbol(6, this);
	arbolLeft11.setLayout(null);
	arbolLeft11.setBounds(39*reescalador, 115*reescalador, arbolLeft11.ANCHURA_SPRITE, arbolLeft11.ALTURA_SPRITE);
	arbolLeft11.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft11);

	arbolLeft12 = new Arbol(16, this);
	arbolLeft12.setLayout(null);
	arbolLeft12.setBounds(91*reescalador, 124*reescalador, arbolLeft12.ANCHURA_SPRITE, arbolLeft12.ALTURA_SPRITE);
	arbolLeft12.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft12);

	arbolLeft13 = new Arbol(18, this);
	arbolLeft13.setLayout(null);
	arbolLeft13.setBounds(124*reescalador, 133*reescalador, arbolLeft13.ANCHURA_SPRITE, arbolLeft13.ALTURA_SPRITE);
	arbolLeft13.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft13);

	arbolLeft14 = new Arbol(20, this);
	arbolLeft14.setLayout(null);
	arbolLeft14.setBounds(141*reescalador, 134*reescalador, arbolLeft14.ANCHURA_SPRITE, arbolLeft14.ALTURA_SPRITE);
	arbolLeft14.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft14);

	///////////////////////////////////

	// Cuarto conjunto
	arbolLeft15 = new Arbol(0, this);
	arbolLeft15.setLayout(null);
	arbolLeft15.setBounds(-41*reescalador, 138*reescalador, arbolLeft15.ANCHURA_SPRITE, arbolLeft15.ALTURA_SPRITE);
	arbolLeft15.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft15);

	arbolLeft16 = new Arbol(3, this);
	arbolLeft16.setLayout(null);
	arbolLeft16.setBounds(16*reescalador, 117*reescalador, arbolLeft16.ANCHURA_SPRITE, arbolLeft16.ALTURA_SPRITE);
	arbolLeft16.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft16);

	arbolLeft17 = new Arbol(15, this);
	arbolLeft17.setLayout(null);
	arbolLeft17.setBounds(82*reescalador, 123*reescalador, arbolLeft17.ANCHURA_SPRITE, arbolLeft17.ALTURA_SPRITE);
	arbolLeft17.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft17);

	arbolLeft18 = new Arbol(17, this);
	arbolLeft18.setLayout(null);
	arbolLeft18.setBounds(118*reescalador, 128*reescalador, arbolLeft18.ANCHURA_SPRITE, arbolLeft18.ALTURA_SPRITE);
	arbolLeft18.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft18);

	arbolLeft19 = new Arbol(19, this);
	arbolLeft19.setLayout(null);
	arbolLeft19.setBounds(140*reescalador, 132*reescalador, arbolLeft19.ANCHURA_SPRITE, arbolLeft19.ALTURA_SPRITE);
	arbolLeft19.setVisible(false);
	
	listaArbolesLeft.add(arbolLeft19);
	
	juego.add(arbolLeft19);
	juego.add(arbolLeft18);
	juego.add(arbolLeft17);
	juego.add(arbolLeft16);
	juego.add(arbolLeft15);
	juego.add(arbolLeft14);
	juego.add(arbolLeft13);
	juego.add(arbolLeft12);
	juego.add(arbolLeft11);
	juego.add(arbolLeft10);
	juego.add(arbolLeft9);
	juego.add(arbolLeft8);
	juego.add(arbolLeft7);
	juego.add(arbolLeft6);
	juego.add(arbolLeft5);
	juego.add(arbolLeft4);
	juego.add(arbolLeft3);
	juego.add(arbolLeft2);
	juego.add(arbolLeft1);
	juego.add(arbolLeft0);
	
	
	/////////ARBOLES DERECHA//////////////
	
	// Primer conjunto
	arbolRight0 = new Arbol(0, this);
	arbolRight0.setLayout(null);
	arbolRight0.setBounds(255 * reescalador, 110 * reescalador, arbolRight0.ANCHURA_SPRITE, arbolRight0.ALTURA_SPRITE);
	arbolRight0.setVisible(true);

	listaArbolesRight.add(arbolRight0);

	arbolRight1 = new Arbol(12, this);
	arbolRight1.setLayout(null);
	arbolRight1.setBounds(215 * reescalador, 121 * reescalador, arbolRight1.ANCHURA_SPRITE, arbolRight1.ALTURA_SPRITE);
	arbolRight1.setVisible(true);

	listaArbolesRight.add(arbolRight1);

	arbolRight2 = new Arbol(17, this);
	arbolRight2.setLayout(null);
	arbolRight2.setBounds(195 * reescalador, 133 * reescalador, arbolRight2.ANCHURA_SPRITE, arbolRight2.ALTURA_SPRITE);
	arbolRight2.setVisible(true);

	listaArbolesRight.add(arbolRight2);

	arbolRight3 = new Arbol(19, this);
	arbolRight3.setLayout(null);
	arbolRight3.setBounds(178 * reescalador, 135 * reescalador, arbolRight3.ANCHURA_SPRITE, arbolRight3.ALTURA_SPRITE);
	arbolRight3.setVisible(true);

	listaArbolesRight.add(arbolRight3);

	arbolRight4 = new Arbol(22, this);
	arbolRight4.setLayout(null);
	arbolRight4.setBounds(168 * reescalador, 135 * reescalador, arbolRight4.ANCHURA_SPRITE, arbolRight4.ALTURA_SPRITE);
	arbolRight4.setVisible(true);

	listaArbolesRight.add(arbolRight4);

	// Segundo conjunto
	arbolRight5 = new Arbol(0, this);
	arbolRight5.setLayout(null);
	arbolRight5.setBounds(270 * reescalador, 118 * reescalador, arbolRight5.ANCHURA_SPRITE, arbolRight5.ALTURA_SPRITE);
	arbolRight5.setVisible(false);

	listaArbolesRight.add(arbolRight5);

	arbolRight6 = new Arbol(9, this);
	arbolRight6.setLayout(null);
	arbolRight6.setBounds(225 * reescalador, 117 * reescalador, arbolRight6.ANCHURA_SPRITE, arbolRight6.ALTURA_SPRITE);
	arbolRight6.setVisible(false);

	listaArbolesRight.add(arbolRight6);

	arbolRight7 = new Arbol(16, this);
	arbolRight7.setLayout(null);
	arbolRight7.setBounds(196 * reescalador, 121 * reescalador, arbolRight7.ANCHURA_SPRITE, arbolRight7.ALTURA_SPRITE);
	arbolRight7.setVisible(false);

	listaArbolesRight.add(arbolRight7);

	arbolRight8 = new Arbol(18, this);
	arbolRight8.setLayout(null);
	arbolRight8.setBounds(178 * reescalador, 132 * reescalador, arbolRight8.ANCHURA_SPRITE, arbolRight8.ALTURA_SPRITE);
	arbolRight8.setVisible(false);

	listaArbolesRight.add(arbolRight8);

	arbolRight9 = new Arbol(21, this);
	arbolRight9.setLayout(null);
	arbolRight9.setBounds(168 * reescalador, 135 * reescalador, arbolRight9.ANCHURA_SPRITE, arbolRight9.ALTURA_SPRITE);
	arbolRight9.setVisible(false);

	listaArbolesRight.add(arbolRight9);

	// Tercer conjunto
	arbolRight10 = new Arbol(0, this);
	arbolRight10.setLayout(null);
	arbolRight10.setBounds(288 * reescalador, 126 * reescalador, arbolRight10.ANCHURA_SPRITE, arbolRight10.ALTURA_SPRITE);
	arbolRight10.setVisible(false);

	listaArbolesRight.add(arbolRight10);

	arbolRight11 = new Arbol(6, this);
	arbolRight11.setLayout(null);
	arbolRight11.setBounds(235 * reescalador, 115 * reescalador, arbolRight11.ANCHURA_SPRITE, arbolRight11.ALTURA_SPRITE);
	arbolRight11.setVisible(false);

	listaArbolesRight.add(arbolRight11);

	arbolRight12 = new Arbol(16, this);
	arbolRight12.setLayout(null);
	arbolRight12.setBounds(202 * reescalador, 124 * reescalador, arbolRight12.ANCHURA_SPRITE, arbolRight12.ALTURA_SPRITE);
	arbolRight12.setVisible(false);

	listaArbolesRight.add(arbolRight12);

	arbolRight13 = new Arbol(18, this);
	arbolRight13.setLayout(null);
	arbolRight13.setBounds(182 * reescalador, 133 * reescalador, arbolRight13.ANCHURA_SPRITE, arbolRight13.ALTURA_SPRITE);
	arbolRight13.setVisible(false);

	listaArbolesRight.add(arbolRight13);

	arbolRight14 = new Arbol(20, this);
	arbolRight14.setLayout(null);
	arbolRight14.setBounds(170 * reescalador, 134 * reescalador, arbolRight14.ANCHURA_SPRITE, arbolRight14.ALTURA_SPRITE);
	arbolRight14.setVisible(false);

	listaArbolesRight.add(arbolRight14);

	// Cuarto conjunto
	arbolRight15 = new Arbol(0, this);
	arbolRight15.setLayout(null);
	arbolRight15.setBounds(308 * reescalador, 138 * reescalador, arbolRight15.ANCHURA_SPRITE, arbolRight15.ALTURA_SPRITE);
	arbolRight15.setVisible(false);

	listaArbolesRight.add(arbolRight15);

	arbolRight16 = new Arbol(3, this);
	arbolRight16.setLayout(null);
	arbolRight16.setBounds(254 * reescalador, 117 * reescalador, arbolRight16.ANCHURA_SPRITE, arbolRight16.ALTURA_SPRITE);
	arbolRight16.setVisible(false);

	listaArbolesRight.add(arbolRight16);

	arbolRight17 = new Arbol(15, this);
	arbolRight17.setLayout(null);
	arbolRight17.setBounds(207 * reescalador, 123 * reescalador, arbolRight17.ANCHURA_SPRITE, arbolRight17.ALTURA_SPRITE);
	arbolRight17.setVisible(false);

	listaArbolesRight.add(arbolRight17);

	arbolRight18 = new Arbol(17, this);
	arbolRight18.setLayout(null);
	arbolRight18.setBounds(184 * reescalador, 128 * reescalador, arbolRight18.ANCHURA_SPRITE, arbolRight18.ALTURA_SPRITE);
	arbolRight18.setVisible(false);

	listaArbolesRight.add(arbolRight18);

	arbolRight19 = new Arbol(19, this);
	arbolRight19.setLayout(null);
	arbolRight19.setBounds(172 * reescalador, 132 * reescalador, arbolRight19.ANCHURA_SPRITE, arbolRight19.ALTURA_SPRITE);
	arbolRight19.setVisible(false);

	listaArbolesRight.add(arbolRight19);

	juego.add(arbolRight19);
	juego.add(arbolRight18);
	juego.add(arbolRight17);
	juego.add(arbolRight16);
	juego.add(arbolRight15);
	juego.add(arbolRight14);
	juego.add(arbolRight13);
	juego.add(arbolRight12);
	juego.add(arbolRight11);
	juego.add(arbolRight10);
	juego.add(arbolRight9);
	juego.add(arbolRight8);
	juego.add(arbolRight7);
	juego.add(arbolRight6);
	juego.add(arbolRight5);
	juego.add(arbolRight4);
	juego.add(arbolRight3);
	juego.add(arbolRight2);
	juego.add(arbolRight1);
	juego.add(arbolRight0);
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
        	try {
    	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/sfx/carMusic66.wav").getAbsoluteFile());
    	        Clip clip = AudioSystem.getClip();
    	        clip.open(audioInputStream);
    	        clip.loop(Clip.LOOP_CONTINUOUSLY);
    	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
    	         System.out.println("Error al reproducir el sonido.");
    	       }
            ejecutarAcciones = new Controlador(this);
            ejecutarAcciones.escucharEventos();
            ejecutarAcciones.mando();
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
            configurarArboles();
            configurarFondo();
            configurarCoche();
            configurarCamino();
            configurarCielo();
            
           
        
            ejecutar();
        }  
     

}
