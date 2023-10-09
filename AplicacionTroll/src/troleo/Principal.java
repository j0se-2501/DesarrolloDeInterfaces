<<<<<<< HEAD
package troleo;

import java.awt.EventQueue;

public class Principal extends Inicio{
	
	
	public static void main(String[] args) {
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
=======
package troleo;

import java.awt.EventQueue;

public class Principal extends Inicio{
	
	
	public static void main(String[] args) {
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
>>>>>>> branch 'main' of https://github.com/j0se-2501/DesarrolloDeInterfaces.git
