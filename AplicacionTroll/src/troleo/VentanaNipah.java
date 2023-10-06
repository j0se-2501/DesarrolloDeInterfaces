package troleo;

import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaNipah {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon gifNipah;
	protected JLabel gifNipahLabel;

	/**
	 * Create the application.
	 */
	public VentanaNipah() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		gifNipah = new ImageIcon("img/nipah.gif");
		gifNipahLabel = new JLabel(gifNipah);
		gifNipahLabel.setBounds(-100, -50, 700, 500);
		panel.add(gifNipahLabel);
		try {
            File file = new File("sfx/nipah.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
