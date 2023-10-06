package troleo;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class Inicio extends VentanaNipah {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon pngTroll;
	protected JLabel pngTrollLabel;
	protected JButton boton;

	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		
		frame = new JFrame();
		frame.setBounds(725, 350, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Not sussy app 100% real I swear ( ͡° ͜ʖ ͡°)");
		frame.addWindowListener(null);
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		pngTroll = new ImageIcon("img/troll.png");
		pngTrollLabel = new JLabel(pngTroll);
		pngTrollLabel.setBounds(-130, 50, 700, 500);
		panel.add(pngTrollLabel);
		boton = new JButton("Click Aquí");
		boton.setBackground(new Color(255, 0, 0));
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		boton.setBounds(170, 73, 100, 36);
		panel.add(boton);
		
		
		
	}

}
