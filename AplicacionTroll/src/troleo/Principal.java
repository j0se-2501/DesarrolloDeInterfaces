package troleo;

import java.awt.EventQueue;

public class Principal extends Inicio{
	
	
	public static void main(String[] args) { //comentario para probar github
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
