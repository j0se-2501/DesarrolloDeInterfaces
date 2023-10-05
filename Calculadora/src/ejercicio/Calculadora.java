package ejercicio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Calculadora {

	private JFrame frame;
	private JPanel panel;
	private JTextField pantalla;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton boton0;
	private JButton botonSumar;
	private JButton botonRestar;
	private JButton botonMultiplicar;
	private JButton botonDividir;
	private JButton botonLimpiar;
	private JButton botonIgual;
	private JButton botonPunto; 
	private String operacionesString;
	private double operaciones;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculadora");
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		pantalla = new JTextField("");
		pantalla.setBounds(0, 0, 250, 70);
		pantalla.requestFocusInWindow(); //con esto se puede escribir directamente en el jtextfield
		panel.add(pantalla);
		
		//botones
		
		boton1 = new JButton("1");
		boton2 = new JButton("2");
		boton3 = new JButton("3");
		boton4 = new JButton("4");
		boton5 = new JButton("5");
		boton6 = new JButton("6");
		boton7 = new JButton("7");
		boton8 = new JButton("8");
		boton9 = new JButton("9");
		boton0 = new JButton("0");
		botonSumar = new JButton("+");
		botonRestar = new JButton("-");
		botonMultiplicar = new JButton("*");
		botonDividir = new JButton("/");
		botonLimpiar = new JButton("C");
		botonIgual = new JButton("=");
		botonPunto = new JButton(".");
		
		//setBounds
		
		pantalla.setBounds(10, 10, 341, 30); // Ubicación y tamaño del campo de texto
		boton1.setBounds(10, 50, 60, 50);     // Ubicación y tamaño del botón 1
		boton2.setBounds(80, 50, 60, 50);     // Ubicación y tamaño del botón 2
		boton3.setBounds(150, 50, 60, 50);    // Ubicación y tamaño del botón 3
		boton4.setBounds(10, 110, 60, 50);    // Ubicación y tamaño del botón 4
		boton5.setBounds(80, 110, 60, 50);    // Ubicación y tamaño del botón 5
		boton6.setBounds(150, 110, 60, 50);   // Ubicación y tamaño del botón 6
		boton7.setBounds(10, 170, 60, 50);    // Ubicación y tamaño del botón 7
		boton8.setBounds(80, 170, 60, 50);    // Ubicación y tamaño del botón 8
		boton9.setBounds(150, 170, 60, 50);   // Ubicación y tamaño del botón 9
		boton0.setBounds(80, 230, 60, 50);    // Ubicación y tamaño del botón 0
		botonSumar.setBounds(220, 50, 60, 50);       // Ubicación y tamaño del botón de suma
		botonRestar.setBounds(220, 110, 60, 50);      // Ubicación y tamaño del botón de resta
		botonMultiplicar.setBounds(220, 170, 60, 50); // Ubicación y tamaño del botón de multiplicación
		botonDividir.setBounds(220, 230, 60, 50);     // Ubicación y tamaño del botón de división
		botonLimpiar.setBounds(10, 230, 60, 50);      // Ubicación y tamaño del botón de limpiar
		botonIgual.setBounds(290, 50, 60, 230);
		botonPunto.setBounds(150, 230, 60, 50);
		
		// Agrega los componentes al panel
		panel.add(pantalla);
		panel.add(boton1);
		panel.add(boton2);
		panel.add(boton3);
		panel.add(boton4);
		panel.add(boton5);
		panel.add(boton6);
		panel.add(boton7);
		panel.add(boton8);
		panel.add(boton9);
		panel.add(boton0);
		panel.add(botonSumar);
		panel.add(botonRestar);
		panel.add(botonMultiplicar);
		panel.add(botonDividir);
		panel.add(botonLimpiar);
		panel.add(botonIgual);
		panel.add(botonPunto);
		
		//listeners
		boton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pantalla.setText(pantalla.getText()+"0");
            	pantalla.requestFocusInWindow(); //de esta forma, aunque pulse un boton, el text area sigue focus y puedo pulsar enter
            }
            
        });
		boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pantalla.setText(pantalla.getText()+"1");
            	pantalla.requestFocusInWindow();
            }
            
        });
		
		boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pantalla.setText(pantalla.getText()+"2");
            	pantalla.requestFocusInWindow();

            }
            
        });
		
		boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pantalla.setText(pantalla.getText()+"3");
            	pantalla.requestFocusInWindow();

            }
            
        });
		
		boton4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "4");
		        pantalla.requestFocusInWindow();
		    }
		});

		boton5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "5");
		        pantalla.requestFocusInWindow();
		    }
		});

		boton6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "6");
		        pantalla.requestFocusInWindow();
		    }
		});

		boton7.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "7");
		        pantalla.requestFocusInWindow();
		    }
		});

		boton8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "8");
		        pantalla.requestFocusInWindow();
		    }
		});

		boton9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "9");
		        pantalla.requestFocusInWindow();
		    }
		});
		
		// Para el botón de suma
		botonSumar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "+");
		        pantalla.requestFocusInWindow();
		    }
		});

		// Para el botón de resta
		botonRestar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "-");
		        pantalla.requestFocusInWindow();
		    }
		});

		// Para el botón de multiplicación
		botonMultiplicar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "*");
		        pantalla.requestFocusInWindow();
		    }
		});

		// Para el botón de división
		botonDividir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + "/");
		        pantalla.requestFocusInWindow();
		    }
		});
		
		botonPunto.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pantalla.setText(pantalla.getText() + ".");
		        pantalla.requestFocusInWindow();
		    }
		});

		botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pantalla.setText("");
            	pantalla.requestFocusInWindow();
            }
            
        });
		
		botonIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	operacionesString = pantalla.getText();
            	
            	try {
            	double operaciones = evaluarOperacion(operacionesString);
            	if (operaciones % 1 == 0) {
                    // Si el resultado es un número entero, mostrarlo sin decimales
                    pantalla.setText(String.valueOf((int) operaciones));
                } else {
                    // Si el resultado tiene decimales, mostrarlo normalmente
                    pantalla.setText(String.valueOf(operaciones));
                }
            	
            	}catch(Exception excepcion) {
            		pantalla.setText("ERROR");
            		pantalla.setEditable(false);
            		Timer timer = new Timer(2000, new ActionListener() { //con este temporizador mantengo el mensaje de error
            															//sin poder editarse durante 2 segundos
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pantalla.setText("");
                            pantalla.setEditable(true);
                            pantalla.requestFocusInWindow();
                            ((Timer) e.getSource()).stop(); // Detener el Timer después de borrar el mensaje
                        }
                    });

                    // Iniciar el Timer
                    timer.start();
            	}
            }
            
        });
		
		pantalla.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
                if (!(c >= '0' && c <= '9') && c != '+' && c != '-' && c != '*' && c != '/' && c != '.') 

                    e.consume(); // he probado a hacerlo con el getKeyCode, pero no lograba hacerlo funcionar con esta misma logica
                    //tanto internet como companneros de clase sugerian hacerlo con getkeycode
                
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Cuando se presiona "Enter", activar el ActionListener del botón "="
                    botonIgual.doClick();
                }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		
		
//Los metodos a continuacion me los ha dado chatGPT tras un ratillo de prompts.
//Basicamente el problema consistía en mantener la jerarquía de los operadores tras+
//convertir el String que proporciona el usuario en el JTextField en una o más operaciones de doubles.
//chatGPT juega con los stacks, los cuales no dimos el curso pasado, más allá de una+
//mención superficial de Olga cuando dimos javascript.
		
//En resumen: convierto el String del usuario en una o varias operaciones de doubles+
//respetando el orden de los operadores.


	}
	
	
	
	public static double evaluarOperacion(String operacionString) {
        Stack<Double> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < operacionString.length(); i++) {
        	
            char caracter = operacionString.charAt(i);

            if (Character.isDigit(caracter) || caracter == '.') {
                StringBuilder numero = new StringBuilder();
                numero.append(caracter);

                // Revisa los siguientes caracteres para formar el número completo
                while (i + 1 < operacionString.length() && (Character.isDigit(operacionString.charAt(i + 1)) || operacionString.charAt(i + 1) == '.')) {
                    numero.append(operacionString.charAt(i + 1));
                    i++;
                }

                numeros.push(Double.parseDouble(numero.toString()));
            } else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
                // Revisa la precedencia de operadores y realiza las operaciones si es necesario
                while (!operadores.isEmpty() && tienePrecedencia(caracter, operadores.peek())) {
                    realizarOperacion(numeros, operadores.pop());
                }
                operadores.push(caracter);
            }
        }

        // Realiza las operaciones restantes
        while (!operadores.isEmpty()) {
            realizarOperacion(numeros, operadores.pop());
        }

        // El resultado final estará en la cima de la pila de números
        return numeros.pop();
    }

    public static boolean tienePrecedencia(char operador1, char operador2) {
        if ((operador2 == '+' || operador2 == '-') && (operador1 == '*' || operador1 == '/')) {
            return false;
        }
        return true;
    }

    public static void realizarOperacion(Stack<Double> numeros, char operador) {
        double num2 = numeros.pop();
        double num1 = numeros.pop();
        double resultado = 0.0;

        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                resultado = num1 / num2;
                break;
        }

        numeros.push(resultado);
    }

}
