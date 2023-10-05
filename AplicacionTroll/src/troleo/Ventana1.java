package troleo;

import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana1 {

	private JFrame frame;
	private JPanel panel;
	private ImageIcon gifRick;
	private JLabel gifRickLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("(~‾▽‾)~♪♬");
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
