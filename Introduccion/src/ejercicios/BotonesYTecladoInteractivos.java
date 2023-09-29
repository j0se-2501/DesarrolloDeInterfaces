package ejercicios;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BotonesYTecladoInteractivos {

	private JFrame frame;
	private JPanel panel;
	private JTextField pantalla;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton botonLimpiar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotonesYTecladoInteractivos window = new BotonesYTecladoInteractivos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BotonesYTecladoInteractivos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		pantalla = new JTextField();
		pantalla.setBounds(0, 0, 250, 70);
		panel.add(pantalla);
		boton1 = new JButton("Pulsa o teclea 1");
		boton1.setBounds(0, 70, 250, 70);
		panel.add(boton1);
		boton2 = new JButton("Pulsa o teclea 2");
		boton2.setBounds(0, 140, 250, 70);
		panel.add(boton2);
		boton3 = new JButton("Pulsa o teclea 3");
		boton3.setBounds(0, 210, 250, 70);
		panel.add(boton3);
		botonLimpiar = new JButton("Limpiar display");
		botonLimpiar.setBounds(0, 280, 250, 70);
		panel.add(botonLimpiar);
		
	}

}
