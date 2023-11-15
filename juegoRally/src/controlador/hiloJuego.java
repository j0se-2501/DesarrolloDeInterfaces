package controlador;

public class hiloJuego implements Runnable {
	
	int FPS = 60;
	
	public void run() {
		// TODO Auto-generated method stub

		//algunas variables para el medodo sleep
		double drawInterval= 1000000000/FPS;
		double nextDrawTime= System.nanoTime() + drawInterval;

		while (this !=null) {
		//System.out.println("test de juego corriendo");

		long tiempoActual =System.nanoTime();

		

		//metodo sleep para poder repintar el personaje
		try {
		double remainingTime= nextDrawTime - System.nanoTime();
		remainingTime=remainingTime/1000000;
		if (remainingTime<0) {
		remainingTime=0;

		}
		Thread.sleep((long) remainingTime);
		nextDrawTime += drawInterval;
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		}


		}
	
	public hiloJuego() {
		
	}

}
