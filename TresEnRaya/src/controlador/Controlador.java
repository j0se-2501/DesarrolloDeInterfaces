package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import vista.Vista;

public class Controlador implements ActionListener {
	
	// Creamos una variable de tipo PintarVentana
    Vista vista;
    boolean cpu = false;
    boolean jugador2 = false;
    boolean cpuPrimera = false;
    boolean turnoX=true;
    boolean casillaVacia=true;
    boolean estadoGuardado=false;
    boolean turnoGuardado=true;
    String[] saveState = new String[9];
    int contadorSecreto=0;
    boolean cpuGuardada;
	boolean cpuPrimeraGuardada;
	boolean jugador2Guardado;

    
    
        /**
     * EL MÉTODO CONSTRUCTOR RECIBIRÁ POR PARÁMETRO UN
     * OBJETO DE TIPO PINTAR VENTANA Y A ESTE OBJETO
     */
     
    public Controlador(Vista vDesactivar) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por parámetro
        // en el constructor de esta clase
        this.vista=vDesactivar;
    }
     
    /**
     * ESTE MÉTODO PONE A LA ESCUCHA DE LOS EVENTOS
     * DE CLIC DE RATON A CADA UNO DE LOS BOTONES
     * DE LA VENTANA CREADA EN EL PAQUETE VISTA
     */
    public void escucharEventos() {
         
        
    	for(int i=0;i<vista.botonera.arrayBotones.length;i++) {
            vista.botonera.arrayBotones[i].addActionListener(this);
        }
    	
    	vista.itemComenzar.addActionListener(this);
    	vista.itemGuardar.addActionListener(this);
    	vista.itemCargar.addActionListener(this);
    	vista.itemAyuda.addActionListener(this);
        
    }
     
    /**
     * ESTE MÉTODO SE ENCARGA DE EJECUTAR LAS ACCIONES
     * 
     */
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource().equals(vista.itemComenzar)) nuevaPartida();
    	if(e.getSource().equals(vista.itemGuardar)) guardarEstado();
    	if(e.getSource().equals(vista.itemCargar)) cargarEstado();
    	if(e.getSource().equals(vista.itemAyuda)) ayuda();
    	if(e.getSource().equals(vista.menuSecreto)) {
    		contadorSecreto++;
    		//if (contadorSecreto==5) rickRoll();
    	}
          
        if(e.getSource().equals(vista.botonera.arrayBotones[0])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[0].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[0].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[1])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[1].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[1].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[2])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[2].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[2].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
        
        else if(e.getSource().equals(vista.botonera.arrayBotones[3])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[3].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[3].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[4])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[4].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[4].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
          
        else if(e.getSource().equals(vista.botonera.arrayBotones[5])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[5].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[5].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
         
        else if(e.getSource().equals(vista.botonera.arrayBotones[6])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[6].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[6].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
         
        else if(e.getSource().equals(vista.botonera.arrayBotones[7])) {
        	
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[7].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[7].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
        
        else if(e.getSource().equals(vista.botonera.arrayBotones[8])) {
        	if (cpu && cpuPrimera) jugarCPU();
        	
            if (turnoX) vista.botonera.arrayBotones[8].setText("X");
            else if (!turnoX) vista.botonera.arrayBotones[8].setText("O");
            
            if (!cpu && turnoX) turnoX = false;
            else if (!cpu && !turnoX) turnoX = true;
            
            if (cpu && !cpuPrimera) jugarCPU();
            esTerminado();
        }
    }
    
    public void jugarCPU() {
        
    }
    
    public void esTerminado() {
    	
    	if (cpu) {
    	if ((!cpuPrimera&&esGanador("X"))||(cpuPrimera&&esGanador("O"))) mostrarResultado("Ganador: Jugador");
    	else if ((cpuPrimera&&esGanador("X"))||(!cpuPrimera&&esGanador("O"))) mostrarResultado("Ganador: CPU");
    	}
    	else if (!cpu) {
    		if (esGanador("X")) mostrarResultado("Ganador: Jugador 1 (X)");
    		else if (esGanador("O")) mostrarResultado("Ganador: Jugador 2 (O)");
    	}
    	for (JButton boton : vista.botonera.arrayBotones) {
    		if (boton.getText().isEmpty()) {
    			casillaVacia=true;
    			break;
    		} else casillaVacia=false;
    	}
    	if (!esGanador("X")&&!esGanador("O")&&!casillaVacia) mostrarResultado("Empate");
    	
    }
    
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
    
    public void nuevaPartida() {
    	for (JButton boton : vista.botonera.arrayBotones) {
    		boton.setText("");
    		boton.setEnabled(false);
    	}
    	turnoX=true;
    	opcionesNuevaPartida();
    }
    
    public void opcionesNuevaPartida() {
    	
    	// Crear opciones de botones
        Object[] opciones = {"Player 1 VS CPU", "CPU VS Player 2", "Player 1 VS Player 2"};
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
            	for (JButton boton : vista.botonera.arrayBotones) {
            		boton.setText("");
            		boton.setEnabled(true);
            	}
                break;
            case 1:
            	cpu=true;
            	cpuPrimera=true;
            	jugador2= false;
            	for (JButton boton : vista.botonera.arrayBotones) {
            		boton.setText("");
            		boton.setEnabled(true);
            	}
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
    
    public void ayuda() {
    	String mensaje =
                "Modos de juego:\n\n" +
                "· Player 1 VS CPU: juegue contra el ordenador. Empiece moviendo. \n" +
                "· CPU VS Player 2: responda a las jugadas de la CPU.\n" +
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
                + "R: Haga click cinco veces en el extremo derecho del menú superior para revelar un secreto.";

        // Mostrar el JOptionPane de ayuda con un botón "Entendido"
        JOptionPane.showMessageDialog(null, mensaje, "Ayuda", JOptionPane.PLAIN_MESSAGE);

        // Puedes agregar más lógica aquí según tus necesidades
    }

}
