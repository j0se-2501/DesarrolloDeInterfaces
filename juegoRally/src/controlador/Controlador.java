package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputButtons;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputDevice;
import com.github.strikerx3.jxinput.enums.XInputButton;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;
import com.github.strikerx3.jxinput.listener.SimpleXInputDeviceListener;
import com.github.strikerx3.jxinput.listener.XInputDeviceListener;

import vista.*;

public class Controlador implements ActionListener, KeyListener, XInputDeviceListener{
	
	// Creamos una variable de tipo PintarVentana
    Vista vista;
    XInputDevice device;
    XInputDevice[] devices;
    XInputComponents components;
    XInputButtons buttons;
    XInputAxes axes;
    /**
     * EL MÉTODO CONSTRUCTOR RECIBIRÁ POR PARÁMETRO UN
     * OBJETO DE TIPO PINTAR VENTANA Y A ESTE OBJETO
     */
     
    public Controlador(Vista vista) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por parámetro
        // en el constructor de esta clase
        this.vista=vista;
    }
    
    
     
    /**
     * ESTE MÉTODO PONE A LA ESCUCHA DE LOS EVENTOS
     * DE CLIC DE RATON A CADA UNO DE LOS BOTONES
     * DE LA VENTANA CREADA EN EL PAQUETE VISTA
     */
    public void escucharEventos() {
        vista.addKeyListener(this);
    }
     
    /**
     * ESTE MÉTODO SE ENCARGA DE EJECUTAR LAS ACCIONES
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
          
      
    	
    }
    
    public void keyPressed(KeyEvent e) {
    	
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
        	vista.carPanel.detenerIzquierda();
        }
        if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
        	vista.carPanel.detenerDerecha();
        }
        if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
        	HiloJuego.velocidadHilo=0;
        	vista.carPanel.decelerar();
        }
        if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
        	vista.carPanel.dejarDeFrenar();
        }
        if (e.getKeyChar() == 'V' || e.getKeyChar() == 'v') {
    		vista.carPanel.quitarTurbo();
    		if(HiloJuego.velocidadGUI==220&&!vista.carPanel.isFrenando()) vista.turbo.encender(true);
    		vista.velocimetroSpeed.turbo(false);
    	}
    }

    @Override
	public void keyTyped(KeyEvent e) {
    	if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
            vista.carPanel.girarIzquierda();
        }
    	if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
        	vista.carPanel.girarDerecha();
        }
    	if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
            vista.carPanel.acelerar();
        }
    	if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
            vista.carPanel.frenar();
        }
    	if (e.getKeyChar() == 'V' || e.getKeyChar() == 'v') {
    		if (HiloJuego.velocidadGUI==220) vista.carPanel.ponerTurbo();
    	}
		
    }
    
    @Override
	public void connected() {
        // Resume the game
    }

    @Override
    public void disconnected() {
        // Pause the game and display a message
    }

    @Override
    public void buttonChanged(final XInputButton button, final boolean pressed) {
        // The given button was just pressed (if pressed == true) or released (pressed == false)
    	if (button == XInputButton.B&&pressed==true) vista.carPanel.acelerar();
    	else if (button == XInputButton.B&&pressed==false) {
    		HiloJuego.velocidadHilo=0;
        	vista.carPanel.decelerar();
    	}
    	if (button == XInputButton.A&&pressed==true) vista.carPanel.frenar();
    	else if (button == XInputButton.A&&pressed==false) vista.carPanel.dejarDeFrenar();
    	//else if (button == XInputAxes.get()
    }

    public void mando() {
    	
    	try {
		
    	devices = XInputDevice.getAllDevices();
    	device = XInputDevice.getDeviceFor(0);
          
    	
        if (device!=null) {
            System.out.println("device poll");
            components = device.getComponents();

            buttons = components.getButtons();
            axes = components.getAxes();

            // Buttons and axes have public fields (although this is not idiomatic Java)

            device.addListener(this);   
             

        } else {
            // Controller is not connected; display a message
        }
    	} catch (XInputNotLoadedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


   
		
		
	
	

}
