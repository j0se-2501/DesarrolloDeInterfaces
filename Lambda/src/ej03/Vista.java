package ej03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Vista extends JFrame {
	
	public JPanel panel = new JPanel();
	public JButton botonReanudar = new JButton();
	public JButton botonDetener = new JButton();
	public JLabel textoHora = new JLabel();
	private Controlador ejecutarAcciones;
	
	
private void configurarPanel() {
	
	panel.setLayout(null);
	configurarBotonReanudar();
	configurarBotonDetener();
	configurarTextoHora();
	panel.add(botonReanudar);
	panel.add(botonDetener);
	panel.add(textoHora);
	
}

private void configurarBotonDetener() {
	
	botonDetener.setText("Detener");
	botonDetener.setBounds(30, 5, 90, 30);
	botonDetener.setVisible(true);
		
}

private void configurarBotonReanudar() {
	
	botonReanudar.setText("Reanudar");
	botonReanudar.setBounds(30, 5, 90, 30);
	botonReanudar.setVisible(false);
	
}

private void configurarTextoHora() {
	
	textoHora.setBounds(220, 5, 240, 30);
	
}

private void ejecutar() {
	
    ejecutarAcciones = new Controlador(this);
    ejecutarAcciones.arrancarTimer();
    ejecutarAcciones.escucharEventos();
      
}

public Vista() {
    
    // Le damos un tamaño a la ventana
    this.setSize(500, 80);
     
    // Agregamos un tículo
    this.setTitle("Reloj");
      
    // Lo centramos en pantalla
    this.setLocationRelativeTo(null);
      
    /* Le decimos que no se puede redimensionar*/
    this.setResizable(false);
      
    // Le decimos que al cerrar la ventana, acabe el programa
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    // Agregamos una lámina a la ventana
    this.getContentPane().add(panel);
    
    /*try {
		UIManager.setLookAndFeel("Darcula");
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
     
    // llamamos al método que configura la lamina fondo
    // y la lamina de los botones
    ejecutar();
    configurarPanel();
    
}  


}
