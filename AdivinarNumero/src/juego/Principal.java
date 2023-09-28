package juego;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Principal {

	static JFrame frame;
	static JPanel panel;
	static JLabel mensajePantalla;
	static JLabel vidasPantalla;
	static JButton boton1;
	static JButton boton2;
	static JTextField inputUsuario;
	static Timer timer;
	static int intento;
	static String intentoString;
	static int vidas=10;
	static String vidasString;
	static int solucion;
	static Scanner sc = new Scanner(System.in);
	static String mensaje;
	static String pantalla;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}	
		
		
	
	public Principal() {
		initialize();
	}
	
	public void initialize() {
		
		//todos los elementos del frame
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel = new JPanel();
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.setLayout(null);
		mensaje= "Pulsa [ESPACIO] para jugar";
		frame.add(panel);
		mensajePantalla = new JLabel();
		mensajePantalla.setHorizontalAlignment(SwingConstants.CENTER);
		mensajePantalla.setText(mensaje);
		mensajePantalla.setBounds(70, 10, 300, 50);
		mensajePantalla.setVisible(true);
		panel.add(mensajePantalla);
		inputUsuario = new JTextField("");
		inputUsuario.setBounds(202,60,30,30);
		inputUsuario.setVisible(false);
		inputUsuario.requestFocusInWindow(null);
		panel.add(inputUsuario);
		vidasString="Vidas: "+vidas;
		vidasPantalla = new JLabel(vidasString);
		vidasPantalla.setBounds(190,200,1000,50);
		vidasPantalla.setVisible(false);
		panel.add(vidasPantalla);
		boton1 = new JButton("Enviar");
		boton1.setBounds(175,100,80,30);
		boton1.setVisible(false);
		panel.add(boton1);
		boton2 = new JButton("Reiniciar");
		boton2.setBounds(155,100,120,30);
		boton2.setVisible(false);
		boton2.setText("Reiniciar");
		panel.add(boton2);
		
		//creamos numero random
		
		solucion=(int)(Math.random() * 100 +1);
		
		//timer para dar la sensacion de que se actualiza el mensaje en pantalla
		//asi, cuando el mensaje resultante es el mismo, la pagina no queda estatica
		
		timer = new Timer(100, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            mensajePantalla.setVisible(true); // Después de 1 segundo, hazlo visible
	        }
	    });
		
		//listener del boton de enviar numero
		
		boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	jugar();

            }
            
        });
		
		//listener del boton reiniciar
		
		boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	generarRandom();
            	
            	jugar();

            }
            
        });
		
		//listener de la tecla intro para validar el intento
		
		inputUsuario.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_ENTER)&&(vidas>0))
					jugar();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		
		//listener de la tecla espacio para empezar el juego
		
		panel.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_SPACE))
					jugar();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		
		
		
	}
		
	
	
	public void reiniciar(String mensaje) {
		
		
		vidasPantalla.setVisible(false);
		boton1.setVisible(false);
		
		mensajePantalla.setVisible(true);
        mensajePantalla.setText(mensaje);
        boton2.setVisible(true); //ahora muestro el boton reiniciar
        
        
	}
	
	public void jugar(){
		
		
		timer.start();
		mensaje="Inserta un numero entre el 1 y el 100";
		mensajePantalla.setText(mensaje);
		vidasPantalla.setVisible(true);
		inputUsuario.setVisible(true);
		boton1.setVisible(true);
		boton2.setVisible(false); //quiero que se muestre el boton de enviar numero y no el de reiniciar
		boton1.setText("Enviar");
		
		if (!inputUsuario.getText().equals("")) {//asi evito los errores de parsear un stream null
			mensajePantalla.setVisible(false); //gracias al timer, esto durara una decima de segundo, dando la sensacion de actualizar el mensaje
       intentoString = inputUsuario.getText();
       {
       intento = Integer.parseInt(intentoString); //comparo el intento del usuario con la solucion
       switch (Integer.compare(intento, solucion)) {
       case -1:
           vidas--;
           mensaje = "El numero secreto es mayor.";
           break;
       case 1:
           vidas--;
           mensaje = "El numero secreto es menor.";
           break;
       case 0:
           mensaje = "El numero secreto ha sido adivinado.";
           reiniciar(mensaje);
            
           break;
   }	
       mensajePantalla.setText(mensaje);
       vidasPantalla.setText("Vidas: "+vidas);
       
       if (vidas == 0) {
   		mensaje = "Game Over. El numero secreto es: " + solucion;
   		reiniciar(mensaje);
              }
	
	      }
       
		}
    
	}
	
	public void generarRandom() {
		
		solucion=(int)(Math.random() * 100 +1);
		inputUsuario.setText("");
		vidas=10;
		vidasPantalla.setText("Vidas: 10");
	}
	
	
	

}
