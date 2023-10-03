package ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PantallaSecundaria2 {

	private JFrame frame2;
	private JPanel panel2;
	private JButton boton2;
	private JLabel label2;

	
	public PantallaSecundaria2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame2 = new JFrame();
		frame2.setBounds(200, 200, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Ventana secundaria");
		panel2 = new JPanel();
		panel2.setLayout(null);
		frame2.add(panel2);
		boton2 = new JButton();
		boton2.setHorizontalAlignment(SwingConstants.CENTER);
		boton2.setVerticalAlignment(SwingConstants.CENTER);
		boton2.setText("Volver");
		boton2.setBounds(148, 125, 150, 50);
		panel2.add(boton2);
		label2 = new JLabel();
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setVerticalAlignment(SwingConstants.CENTER);
		label2.setText("Ventana secundaria");
		label2.setBounds(148, 65, 150, 50);
		panel2.add(label2);
		boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PantallaSecundaria.frame.setEnabled(true);
            	frame2.dispose();
			 }
	});
		
	}

	public JFrame getFrame2() {
		return frame2;
	}

	public void setFrame2(JFrame frame2) {
		this.frame2 = frame2;
	}

}
