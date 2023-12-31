package controlador;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import vista.Vista;

/**La clase Controlador maneja la lógica del juego.*/

public class Controlador implements ActionListener, MenuListener {
	
	// Creamos una variable de tipo PintarVentana
    Vista vista;
    /**si juega la cpu*/
    boolean cpu = false;
    /**si hay jugador 2*/
    boolean jugador2 = false;
    /**si la cpu juega primero*/
    boolean cpuPrimera = false;
    /**si es el turno de la X*/
    boolean turnoX=true;
    /**si la casilla está vacía*/
    boolean casillaVacia=true;
    /**si hay un estado guardado*/
    boolean estadoGuardado=false;
    /**si es el turno guardado*/
    boolean turnoGuardado=true;
    /**casillas que se quedan guardadas*/
    String[] saveState = new String[9];
    /**contador para un secreto*/
    int contadorSecreto=0;
    /**si hay cpu en la partida guardada*/
    boolean cpuGuardada;
    /**si la cpu juega primero en la partida guardada*/
	boolean cpuPrimeraGuardada;
	/**si hay jugador 2 en la partida guardada*/
	boolean jugador2Guardado;
	/**si la partida ha terminado*/
	boolean haTerminado=false;
	/**letra de la cpu*/
	String letraCPU="O";
	/**letra del jugador vs la cpu*/
	String letraHumano="X";

    
    
     /**
     * Recibe la vista con la que trabaja el controlador
     */
     
    public Controlador(Vista vista) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por parámetro
        // en el constructor de esta clase
        this.vista=vista;
    }
     
    /**
     * listeners de los clicks del ratón 
     */
    public void escucharEventos() {
         
        
    	for(int i=0;i<vista.botonera.arrayBotones.length;i++) {
            vista.botonera.arrayBotones[i].addActionListener(this);
        }
    	
    	vista.itemComenzar.addActionListener(this);
    	vista.itemGuardar.addActionListener(this);
    	vista.itemCargar.addActionListener(this);
    	vista.itemAyuda.addActionListener(this);
    	vista.menuJuego.addMenuListener(this);
    	vista.menuSecreto.addMenuListener(this);
    }
     
    /**
     * acciones tras hacerse click
     * 
     */
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource().equals(vista.itemComenzar)) nuevaPartida();
    	if(e.getSource().equals(vista.itemGuardar)) guardarEstado();
    	if(e.getSource().equals(vista.itemCargar)) cargarEstado();
    	if(e.getSource().equals(vista.itemAyuda)) ayuda();
    	if(e.getSource().equals(vista.menuJuego)) {
    		contadorSecreto++;
    		if (contadorSecreto==10) vista.menuSecreto.setVisible(true);
    	}
          
        if(e.getSource().equals(vista.botonera.arrayBotones[0])&&vista.botonera.arrayBotones[0].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[0].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[0].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[1])&&vista.botonera.arrayBotones[1].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[1].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[1].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[2])&&vista.botonera.arrayBotones[2].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[2].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[2].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
        
        else if(e.getSource().equals(vista.botonera.arrayBotones[3])&&vista.botonera.arrayBotones[3].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[3].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[3].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[4])&&vista.botonera.arrayBotones[4].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[4].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[4].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[5])&&vista.botonera.arrayBotones[5].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[5].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[5].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
         
        else if(e.getSource().equals(vista.botonera.arrayBotones[6])&&vista.botonera.arrayBotones[6].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[6].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[6].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
         
        else if(e.getSource().equals(vista.botonera.arrayBotones[7])&&vista.botonera.arrayBotones[7].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[7].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[7].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
        
        else if(e.getSource().equals(vista.botonera.arrayBotones[8])&&vista.botonera.arrayBotones[8].getText().isEmpty()) {
        	
        	haTerminado=false;
            if (turnoX) vista.botonera.arrayBotones[8].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[8].setText("O");
            if (esTerminado()) return;
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !haTerminado) jugarCPU();
            if (esTerminado()) return;
        }
    }
    
    /**método que llama a la cpu para que juegue*/
    
    public void jugarCPU() {
        if (cpuPrimera) {
        	letraCPU = "X";
        	letraHumano = "O";
        }
        else if (!cpuPrimera) {
        	letraCPU = "O";
        	letraHumano = "X";
        }

        if (cpu) {
            if (haTerminado) return; // Si el juego ha terminado, no realizar más movimientos

            if (vista.botonera.arrayBotones[4].getText().isEmpty()) {
                // Ocupar la casilla central
                vista.botonera.arrayBotones[4].setText(letraCPU);
                esTerminado();
                return;
            } else if (!haTerminado){

            int[] mejorMovimiento = minimax(2, letraCPU);
            int mejorIndice = mejorMovimiento[1];

            if (vista.botonera.arrayBotones[mejorIndice].getText().isEmpty()&&!haTerminado) {
                vista.botonera.arrayBotones[mejorIndice].setText(letraCPU);
                esTerminado();
            	}
            
            }
        }
    }
    
    /**inteligencia de la CPU. Funciona bien cuando empieza moviendo el jugador. Proporcionado y modificado desde ChatGPT*/
    
    private int[] minimax(int profundidad, String jugador) {
        int mejorPuntaje = (jugador.equals(letraCPU)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int mejorMovimiento = 4;

        if (profundidad == 0 || esTerminado()) {
            mejorPuntaje = evaluarTablero();
        } else {
            for (int i = 0; i < 9; i++) {
                if (vista.botonera.arrayBotones[i].getText().isEmpty()&&!haTerminado) {
                    vista.botonera.arrayBotones[i].setText(jugador);

                    if (jugador.equals(letraCPU)) {
                        int puntaje = minimax(profundidad - 1, letraHumano)[0];
                        if (puntaje > mejorPuntaje) {
                            mejorPuntaje = puntaje;
                            mejorMovimiento = i;
                        }
                    } else {
                        int puntaje = minimax(profundidad - 1, letraCPU)[0];
                        if (puntaje < mejorPuntaje) {
                            mejorPuntaje = puntaje;
                            mejorMovimiento = i;
                        }
                    }

                    vista.botonera.arrayBotones[i].setText("");
                }
            }
        }

        return new int[]{mejorPuntaje, mejorMovimiento};
    }
    
    
    /**continuación del algoritmo minimax*/
    private int evaluarTablero() {
        if (esGanador("X")) {
            return -1;
        } else if (esGanador("O")) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**comprueba si ha terminado la partida llamando a esGanador() y si es así, llama a mostrarResultado()*/
    public boolean esTerminado() {
    	
    	if (cpu) {
    	if ((!cpuPrimera&&esGanador("X"))||(cpuPrimera&&esGanador("O"))) {
    		mostrarResultado("Ganador: Jugador");
    		haTerminado=true;
    		return haTerminado;
    	}
    	else if ((cpuPrimera&&esGanador("X"))||(!cpuPrimera&&esGanador("O"))) {
    		mostrarResultado("Ganador: CPU");
    		haTerminado=true;
    		return haTerminado;
    	}
    	}
    	else if (!cpu) {
    		if (esGanador("X")) {
    			mostrarResultado("Ganador: Jugador 1 (X)");
    			haTerminado=true;
        		return haTerminado;
    		}
    		else if (esGanador("O")) {
    			mostrarResultado("Ganador: Jugador 2 (O)");
    			haTerminado=true;
        		return haTerminado;
    		}
    	}
    	for (JButton boton : vista.botonera.arrayBotones) {
    		if (boton.getText().isEmpty()) {
    			casillaVacia=true;
    			break;
    		} else casillaVacia=false;
    	}
    	if (!esGanador("X")&&!esGanador("O")&&!casillaVacia) {
    		mostrarResultado("Empate");
    		haTerminado=true;
    		return haTerminado;
    	}
    	
    	haTerminado=false;
		return haTerminado;
    	
    }
    
    /**muestra un mensaje por pantalla según el resultado de la partida*/
    
    public void mostrarResultado(String mensaje) {
    	// Crear un JLabel con el texto centrado
        JLabel label = new JLabel(mensaje, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Puedes ajustar la fuente según tus preferencias
     // Crear opciones de botones
        Object[] opciones = {"Nueva partida", "Salir"};

        // Mostrar el JOptionPane con dos opciones
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, label, "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        // Procesar la opción seleccionada
        switch (opcionSeleccionada) {
            case 0:
                nuevaPartida();
                break;
            case 1:
                // Lógica para "Salir"
                System.exit(0); // Puedes cambiar esto según lo que quieras hacer al salir
                break;
            default:
                break;
        }
      
    }
    
    /**comprueba si ha habido un ganador*/
    
    public boolean esGanador(String marca) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (vista.botonera.arrayBotones[i * 3].getText().equals(marca) &&
                vista.botonera.arrayBotones[i * 3 + 1].getText().equals(marca) &&
                vista.botonera.arrayBotones[i * 3 + 2].getText().equals(marca)) {
                return true;
            }
        }

        // Verificar columnas
        for (int i = 0; i < 3; i++) {
            if (vista.botonera.arrayBotones[i].getText().equals(marca) &&
                vista.botonera.arrayBotones[i + 3].getText().equals(marca) &&
                vista.botonera.arrayBotones[i + 6].getText().equals(marca)) {
                return true;
            }
        }

        // Verificar diagonales
        if (vista.botonera.arrayBotones[0].getText().equals(marca) &&
            vista.botonera.arrayBotones[4].getText().equals(marca) &&
            vista.botonera.arrayBotones[8].getText().equals(marca)) {
            return true;
        }

        if (vista.botonera.arrayBotones[2].getText().equals(marca) &&
            vista.botonera.arrayBotones[4].getText().equals(marca) &&
            vista.botonera.arrayBotones[6].getText().equals(marca)) {
            return true;
        }

        return false; // No hay ganador
    }
    
    /**inicia una nueva partida*/
    
    public void nuevaPartida() {
    	for (JButton boton : vista.botonera.arrayBotones) {
    		boton.setText("");
    		boton.setEnabled(false);
    	}
    	turnoX=true;
    	haTerminado=false;
    	opcionesNuevaPartida();
    }
    
    /**muestra los distintos modos de juego y ajusta las variables según el modo elegido*/
    
    public void opcionesNuevaPartida() {
    	
    	// Crear opciones de botones
        Object[] opciones = {"Player 1 VS CPU (Difícil)", "CPU VS Player 2 (Fácil)", "Player 1 VS Player 2"};
        JLabel label = new JLabel("Seleccione el modo de juego:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));

        // Mostrar el JOptionPane con tres opciones
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                null,
                label,
                "Nueva Partida",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        // Procesar la opción seleccionada
        switch (opcionSeleccionada) {
            case 0:
            	cpu=true;
            	cpuPrimera=false;
            	jugador2= false;
            	turnoX=true;
            	for (JButton boton : vista.botonera.arrayBotones) {
            		boton.setText("");
            		boton.setEnabled(true);
            	}
                break;
            case 1:
            	cpu=true;
            	cpuPrimera=true;
            	jugador2= false;
            	turnoX=false;
            	for (JButton boton : vista.botonera.arrayBotones) {
            		boton.setText("");
            		boton.setEnabled(true);
            	}
            	jugarCPU();
                break;
            case 2:
            	cpu=false;
            	cpuPrimera=false;
            	jugador2= true;
            	for (JButton boton : vista.botonera.arrayBotones) {
            		boton.setText("");
            		boton.setEnabled(true);
            	}
                break;
            default:
                break;
        }
    	
    }
    
    /**guarda el estado de la partida*/
    
    public void guardarEstado() {
    	estadoGuardado=true;
    	turnoGuardado=turnoX;
    	cpuGuardada = cpu;
    	cpuPrimeraGuardada=cpuPrimera;
    	jugador2Guardado=jugador2;
    		for (int i=0; i<9; i++) {
    			saveState[i]=vista.botonera.arrayBotones[i].getText();
    		}
    }
    
    /**carga el estado de la partida*/
    
    public void cargarEstado() {
    	if (!estadoGuardado) {
    		JLabel label = new JLabel("No se ha guardado partida.", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 14));
    		JOptionPane.showMessageDialog(null, label, "Aviso", JOptionPane.PLAIN_MESSAGE);
    	}else 
    	for (int i=0; i<9; i++) {
    		turnoX=turnoGuardado;
    		cpu=cpuGuardada;
        	cpuPrimera=cpuPrimeraGuardada;
        	jugador2=jugador2Guardado;
    		vista.botonera.arrayBotones[i].setText(saveState[i]);
    	}
		
    }
    
    /**muestra el panel de ayuda al jugador*/
    
    public void ayuda() {
    	String mensaje =
                "Modos de juego:\n\n" +
                "· Player 1 VS CPU: juegue contra el ordenador. Empiece moviendo. Nivel: Difícil \n" +
                "· CPU VS Player 2: responda a las jugadas de la CPU. Nivel: Fácil\n" +
                "· Player 1 VS Player 2: diviértase con un amigo.\n\n" +
                "Cómo jugar:\n\n" +
                "Pulse una casilla y dibujará su marca.\nConsiga tres en línea vertical, horizontal o diagonalmente para ganar.\n" +
                "En caso de agotar las nueve casillas y no haber un ganador, resultará en empate.\n\n" +
                "Opciones:\n\n" +
                "· Nueva Partida: comience de nuevo su partida.\n" +
                "· Guardar: guarde el estado de su partida.\n" +
                "· Cargar: cargue el estado de su partida.\n\n\n"
                + "FAQs:\n\n"
                + "P: ¿Es esta guía realmente útil?\n"
                + "R: Lo dudo mucho, pero al menos aporta cierta profesionalidad.\n\n"
                + "P: ¿Por qué existe esto si el tres en raya es una ba-\n"
                + "R: No me daba tiempo de hacer el ejercicio del ajedrez LULE.\n\n"
                + "P: Ahora en serio. ¿Hay algo que deba saber?\n"
                + "R: Pulsa varias veces sobre el menú de opciones para revelar un secreto.";

        // Mostrar el JOptionPane de ayuda con un botón "Entendido"
        JOptionPane.showMessageDialog(null, mensaje, "Ayuda", JOptionPane.PLAIN_MESSAGE);

        // Puedes agregar más lógica aquí según tus necesidades
    }

    
    /**ejecuta acciones sobre los menús de la barra de menú*/
    
	@Override
	public void menuSelected(MenuEvent e) {
		if (e.getSource().equals(vista.menuJuego)) {
            contadorSecreto++;
            if (contadorSecreto == 10) {
                vista.menuSecreto.setVisible(true);
            }
        }
		if (e.getSource().equals(vista.menuSecreto)) {
			try {
	            // Especificar la URL que deseas abrir en el navegador
	            URI uri = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");

	            // Abrir la URL en el navegador web predeterminado
	            Desktop.getDesktop().browse(uri);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
        }
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

}
