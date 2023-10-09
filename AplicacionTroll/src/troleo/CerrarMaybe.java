package troleo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class CerrarMaybe {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon pngTroll;
	protected JLabel pngTrollLabel;
	protected JButton boton;

	public CerrarMaybe(boolean deVerdad) {
		initialize(deVerdad);
	}

	protected void initialize(boolean deVerdad) {
		
		frame = new JFrame();
		frame.setBounds(725, 350, 270, 140);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("nipaaah~~ (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		frame.addWindowListener(null);
		frame.requestFocusInWindow();
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		if (!deVerdad) {
			
			boton = new JButton("Cerrar?");
			
		} else {
			
			boton = new JButton("Cerrar");
			boton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	VentanaRick ventanaRick = new VentanaRick();
	            	ventanaRick.frame.setVisible(true);
	                
	            }
	        });
		}
		boton.setBackground(new Color(0, 0, 180));
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		boton.setBounds(85, 35, 100, 35);
		panel.add(boton);
		
    }

}
