package troleo;

import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaRick {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon gifRick;
	protected JLabel gifRickLabel;

	/**
	 * Create the application.
	 */
	public VentanaRick() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Considérate Rickrolleado");
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		gifRick = new ImageIcon("img/rickroll.gif");
		gifRickLabel = new JLabel(gifRick);
		gifRickLabel.setBounds(-100, -50, 700, 500);
		panel.add(gifRickLabel);
		try {
            File file = new File("sfx/rick.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
