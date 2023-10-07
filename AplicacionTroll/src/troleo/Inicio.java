package troleo;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Inicio {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon pngTroll;
	protected JLabel pngTrollLabel;
	protected JButton boton;
	protected int contador = 0;
	protected VentanaScream ventanaScream;

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
		
		boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	VentanaNipah ventanaNipah = new VentanaNipah(true);
                ventanaNipah.frame.setVisible(true);
                frame.dispose();
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (contador < 8) {
                            VentanaNipah ventanaNipah = new VentanaNipah(false);
                            ventanaNipah.frame.setVisible(true);
                            contador++;
                        } else {
                            ((Timer) evt.getSource()).stop();
                            CerrarMaybe cerrarMaybe = new CerrarMaybe(false);
                            cerrarMaybe.frame.setVisible(true);
                        }
                    }
                });
                timer.start();
                timer = new Timer(32000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	ventanaNipah.clip.stop();
                        // Cerrar todas las ventanas
                        for (Window window : Window.getWindows()) {
                            if (window instanceof JFrame) {
                                window.dispose();
                            }
                        }

                        // Detener la música (sustituye esta línea por tu lógica de detener la música)
                        // Ejemplo: reproductorDeMusica.stop();

                        // Abrir una nueva ventana de otra clase
                        ventanaScream = new VentanaScream();
                        ventanaScream.frame.setVisible(true);
                        
                        // Detener el temporizador después de realizar las acciones
                        ((Timer) e.getSource()).stop();
                        Timer cerrarVentanaTimer = new Timer(6000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	ventanaScream.clip.stop();
                            	ventanaScream.frame.dispose();
                            	CerrarMaybe cerrarMaybe = new CerrarMaybe(true);
                                cerrarMaybe.frame.setVisible(true);
                            }
                        });
                        cerrarVentanaTimer.setRepeats(false); // Esto asegura que el temporizador se ejecute solo una vez
                        cerrarVentanaTimer.start();
                    }
                });
                timer.start();
                
            }
        });
    }

}
