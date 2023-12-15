package vista;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Controlador;

/**
 * La clase Vista representa la interfaz gráfica principal del juego "Tres en raya".
 */
public class Vista extends JFrame {
	
    /** La botonera que contiene los botones del juego. */
    public Botonera botonera;
    
    /** El controlador que gestiona la lógica del juego. */
    public Controlador controlador;
    
    /** La barra de menú de la interfaz. */
    public JMenuBar menuBar;
    
    /** El menú principal "Opciones" en la barra de menú. */
    public JMenu menuJuego;
    
    /** Item del menú para comenzar una nueva partida. */
    public JMenuItem itemComenzar;
    
    /** Item del menú para guardar la partida. */
    public JMenuItem itemGuardar;
    
    /** Item del menú para cargar una partida guardada. */
    public JMenuItem itemCargar;
    
    /** Item del menú para obtener ayuda sobre el juego. */
    public JMenuItem itemAyuda;
    
    /** Menú "Secreto" que puede ser mostrado en ciertas circunstancias. */
    public JMenu menuSecreto;
    
    /** Identificador de versión de la clase para serialización. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la clase Vista. Inicializa la interfaz gráfica y sus componentes.
     */
    public Vista() {
        // Configuración de la ventana principal
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

        // Menú Secreto
        menuSecreto = new JMenu("Secreto");
        menuSecreto.setVisible(false);
        menuBar.add(Box.createHorizontalGlue());  // Espaciado flexible para alinear a la derecha
        menuBar.add(menuSecreto);

        // Establecer la barra de menú en la ventana
        setJMenuBar(menuBar);

        // Inicializar la botonera
        this.botonera = new Botonera();
        this.add(botonera);

        // Establecer el tamaño de la ventana
        this.setSize(600, 600);

        // Centrar la ventana en la pantalla
        this.setLocationRelativeTo(null);

        // Inicializar el controlador y configurar la partida
        this.controlador = new Controlador(this);
        controlador.nuevaPartida();
        controlador.escucharEventos();
    }
}

