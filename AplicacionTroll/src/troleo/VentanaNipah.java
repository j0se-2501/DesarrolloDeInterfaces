package troleo;

import java.io.File;
import java.util.Random;

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
	protected Random random = new Random(); //para que aparezca la ventana
											//en lugares aleatorios
	protected Clip clip;

	
	public VentanaNipah(boolean sonido) {
		initialize(sonido);
	}
	
	protected void initialize(boolean sonido) {
		frame = new JFrame(); //anchura 0-1250, altura 0-600
		int anchura = random.nextInt(1251);
        int altura = random.nextInt(601);
		frame.setBounds(anchura, altura, 480, 360);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("nipaaah~~ (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		gifNipah = new ImageIcon("img/nipah.gif");
		gifNipahLabel = new JLabel(gifNipah);
		gifNipahLabel.setBounds(0, 0, 480, 360);
		panel.add(gifNipahLabel);
		if (sonido) {
		try {
            File file = new File("sfx/nipah.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
		}
	}

}
