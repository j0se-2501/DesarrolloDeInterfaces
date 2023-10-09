<<<<<<< HEAD
package troleo;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaScream {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon gifScream;
	protected JLabel gifScreamLabel;
	protected JButton boton;
	protected Clip clip;
	
	public VentanaScream() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("nipaaah~~ (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		gifScream = new ImageIcon("img/screamer.gif");
		gifScreamLabel = new JLabel(gifScream);
		gifScreamLabel.setBounds(-70, 0, 1920, 1080);
		panel.add(gifScreamLabel);
		
		try {
            File file = new File("sfx/screamer.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
	
	}
}
=======
package troleo;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaScream {

	protected JFrame frame;
	protected JPanel panel;
	protected ImageIcon gifScream;
	protected JLabel gifScreamLabel;
	protected JButton boton;
	protected Clip clip;
	
	public VentanaScream() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("nipaaah~~ (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		gifScream = new ImageIcon("img/screamer.gif");
		gifScreamLabel = new JLabel(gifScream);
		gifScreamLabel.setBounds(-70, 0, 1920, 1080);
		panel.add(gifScreamLabel);
		
		try {
            File file = new File("sfx/screamer.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
	
	}
}
>>>>>>> branch 'main' of https://github.com/j0se-2501/DesarrolloDeInterfaces.git
