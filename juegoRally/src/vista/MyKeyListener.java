package vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    @Override
   public void keyPressed(KeyEvent e) {
        // Verifica si la tecla presionada es la "A"
        if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
            // Realiza las acciones que desees cuando se presiona la tecla "A"
            System.out.println("Tecla A presionada");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	
    }
}
