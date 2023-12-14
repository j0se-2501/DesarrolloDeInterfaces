package vista;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Controlador;

public class Vista extends JFrame {
	
	public Botonera botonera;
	public Controlador controlador;
	public JMenuBar menuBar;
	public JMenu menuJuego;
	public JMenuItem itemComenzar;
	public JMenuItem itemGuardar;
	public JMenuItem itemCargar;
	public JMenuItem itemAyuda;
	public JMenu menuSecreto;
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Vista() {
        	
        	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        	this.setTitle("Tres en raya");
        	
        	// Crear la barra de menú
        	menuBar = new JMenuBar();

            // Menú Juego
            menuJuego = new JMenu("Opciones");

            // Items del menú Juego
            itemComenzar = new JMenuItem("Nueva partida");
            itemGuardar = new JMenuItem("Guardar");
            itemCargar = new JMenuItem("Cargar");
            itemAyuda = new JMenuItem("Ayuda");

            // Agregar items al menú Juego
            menuJuego.add(itemComenzar);
            menuJuego.add(itemGuardar);
            menuJuego.add(itemCargar);
            menuJuego.add(itemAyuda);

            // Agregar menú Juego a la barra de menú
            menuBar.add(menuJuego);
            
            menuSecreto = new JMenu("Secreto");
            menuSecreto.setVisible(false);
            menuBar.add(Box.createHorizontalGlue());
            menuBar.add(menuSecreto);

            // Establecer la barra de menú en la ventana
            setJMenuBar(menuBar);

            this.botonera = new Botonera();
            this.add(botonera);

            // Establecer el tamaño de la ventana
            this.setSize(600, 600);
            
            // Centrar la ventana en la pantalla
            this.setLocationRelativeTo(null);
            
            this.controlador = new Controlador(this);
            controlador.nuevaPartida();
            controlador.escucharEventos();
        	
        }
        

}
