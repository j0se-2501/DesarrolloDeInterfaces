package ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		pantalla.requestFocusInWindow(); //con esto se puede escribir directamente en el jtextfield
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
		//listener del boton de enviar numero
		
				boton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	pantalla.setText(pantalla.getText()+"1");
		            }
		            
		        });
				
				//listener del boton reiniciar
				
				boton2.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	pantalla.setText(pantalla.getText()+"2");

		            }
		            
		        });
				
				//listener de la tecla intro para validar el intento
				
				boton3.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	pantalla.setText(pantalla.getText()+"3");

		            }
		            
		        });
				
				botonLimpiar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	pantalla.setText("");

		            }
		            
		        });
				
				pantalla.addKeyListener(new KeyListener() {
					
					
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
		                if (c != '1' && c != '2' && c != '3') {
		                    e.consume(); // he probado a hacerlo con el getKeyCode, pero no lograba hacerlo funcionar con esta misma logica
		                    //tanto internet como companneros de clase sugerian hacerlo con getkeycode
		                }
					}

					@Override
					public void keyPressed(KeyEvent e) {
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						
						
					}
				});
		
	}

}
