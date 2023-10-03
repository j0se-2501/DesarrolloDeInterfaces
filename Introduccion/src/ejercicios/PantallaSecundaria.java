package ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PantallaSecundaria {

	public static JFrame frame;
	private JPanel panel;
	private JButton boton;
	private JLabel label;
	public PantallaSecundaria window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaSecundaria window = new PantallaSecundaria();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaSecundaria() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Ventana principal");
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		boton = new JButton();
		boton.setHorizontalAlignment(SwingConstants.CENTER);
		boton.setVerticalAlignment(SwingConstants.CENTER);
		boton.setText("Haz click aquí");
		boton.setBounds(148, 125, 150, 50);
		panel.add(boton);
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setText("Ventana principal");
		label.setBounds(148, 65, 150, 50);
		panel.add(label);
		
		boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PantallaSecundaria2 window2 = new PantallaSecundaria2();
				window2.getFrame2().setVisible(true);
            	getFrame().setEnabled(false);
            }
            
        });
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
