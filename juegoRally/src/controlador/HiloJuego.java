package controlador;

import vista.Vista;

public class HiloJuego implements Runnable {

    int nCamino = 0;
    Controlador controlador;
    int velocidadActual;
    double factorPerdidaTracción;
    double k = 0.05;
    double nuevaVelocidad;
    int tiempoEspera, velocidadMaxima = 220;

    public void run() {
        // TODO Auto-generated method stub

        while (true) {

            if (controlador.vista.carPanel.isGirandoIzquierda())
                controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (7 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            if (controlador.vista.carPanel.isGirandoDerecha())
                controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (7 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            if (controlador.vista.carPanel.isAcelerando()) {

                if (velocidadActual < 40)
                    factorPerdidaTracción = 0.5; // Reducción de aceleración durante la pérdida de tracción
                else
                    factorPerdidaTracción = 1.0; // Restablecer el factor a 1.0 después de la pérdida de tracción

                // Fase 2: Aceleración hasta el 90% de la velocidad máxima
                if (velocidadActual < 0.9 * velocidadMaxima) {
                    k = 0.03; // Ajusta este valor según sea necesario (menor valor para disminuir la aceleración)
                }

                // Fase 3: Aceleración restante hasta el 100% de la velocidad máxima
                else {
                    k = 0.02; // Ajusta este valor según sea necesario (puedes incrementarlo un poco)
                }

                // Calcular la nueva velocidad con una función de logística y el factor de ajuste
                nuevaVelocidad = (int) (velocidadMaxima
                        / (1 + Math.exp(-k * (velocidadActual - 100)))) * factorPerdidaTracción;

                // Imprimir la velocidad actual (puedes comentar o eliminar esta línea en tu aplicación real)
                System.out.println("Velocidad actual: " + velocidadActual);

                // Establecer la nueva velocidad
                velocidadActual = (int) Math.min(nuevaVelocidad, velocidadMaxima);

                // Calcular el tiempo de espera en función de la velocidad
                tiempoEspera = Math.max(1, 1000 / velocidadActual); // El tiempo mínimo es 1 ms

                // Establecer la nueva velocidad
                controlador.vista.carPanel.setVelocidad((int) nuevaVelocidad);

                controlador.vista.pathPanel.moverCamino(nCamino);
                nCamino++;
                if (nCamino == 8)
                    nCamino = 0;
            }

            // if(controlador.vista.carPanel.isFrenando());

            tiempoEspera = Math.max(0, 30 - controlador.vista.carPanel.getVelocidad());

            try {

                Thread.sleep(tiempoEspera);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public HiloJuego(Controlador controlador) {

        this.controlador = controlador;
    }

}
