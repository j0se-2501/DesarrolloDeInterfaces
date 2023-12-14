package vista;

import javax.swing.*;
import java.awt.*;

public class Botonera extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton[] arrayBotones = new JButton[9];

	public Botonera() {
        setLayout(new GridLayout(3, 3, -1, -1)); // El último par de parámetros establece el espacio entre los componentes

        // Crear y agregar botones
        for (int i = 0; i < 9; i++) {
            this.arrayBotones[i] = new JButton();
            this.arrayBotones[i].setBackground(Color.WHITE);
            this.arrayBotones[i].setOpaque(true);
            this.arrayBotones[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.arrayBotones[i].setFont(new Font("Arial", Font.BOLD, 200));
            this.arrayBotones[i].setText("");
            this.add(arrayBotones[i]);
        }
    }

    
}

