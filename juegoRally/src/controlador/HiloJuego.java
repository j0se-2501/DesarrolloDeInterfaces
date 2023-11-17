package controlador;

import sprites.Car;
import vista.Vista;

public class HiloJuego implements Runnable {

    int nCamino = 0;
    Controlador controlador;
    static double velocidadHilo;
    public static int velocidadGUI;
    static boolean turbo;

    public void run() {
        // TODO Auto-generated method stub

        while (true) {
        	
        	System.out.println(velocidadGUI);
        	
        	if (controlador.vista.carPanel.getVelocidad()==0) {
        		controlador.vista.velocimetroDigitos[0].setVisible(true);
        		controlador.vista.velocimetroDigitos[1].setVisible(false);
        		controlador.vista.velocimetroDigitos[2].setVisible(false);
        		controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI);
        	}
        	else if(velocidadGUI>=10&&velocidadGUI<100) {
        		controlador.vista.velocimetroDigitos[0].setVisible(true);
        		controlador.vista.velocimetroDigitos[1].setVisible(true);
        		controlador.vista.velocimetroDigitos[2].setVisible(false);
        		if(velocidadGUI==10) controlador.vista.velocimetroDigitos[0].cambiarNumero(1);
        		else controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI/10);
        		controlador.vista.velocimetroDigitos[1].cambiarNumero(0);
        	}
        	else if(velocidadGUI>=100&&velocidadGUI<=220) {
        		
        		controlador.vista.velocimetroDigitos[0].setVisible(true);
        		controlador.vista.velocimetroDigitos[1].setVisible(true);
        		controlador.vista.velocimetroDigitos[2].setVisible(true);
        		controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI/100);
        		controlador.vista.velocimetroDigitos[1].cambiarNumero((velocidadGUI/10)%10);
        		controlador.vista.velocimetroDigitos[2].cambiarNumero(0);
        		
        	}
        	

            if (controlador.vista.carPanel.isGirandoIzquierda()&&controlador.vista.carPanel.getVelocidad()>0)
                controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (7 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            if (controlador.vista.carPanel.isGirandoDerecha()&&controlador.vista.carPanel.getVelocidad()>0)
                controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (7 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            if (controlador.vista.carPanel.isAcelerando()) {
            	
                controlador.vista.pathPanel.moverCamino(nCamino);
                nCamino++;
                if (nCamino == 8)
                    nCamino = 0;
                
                velocidadHilo=velocidadHilo+0.25;
                		
                if (controlador.vista.carPanel.getVelocidad()<1) {
                    controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()+36);
                	velocidadHilo=50;
                	if(velocidadGUI<20) velocidadGUI=velocidadGUI+10;
                }
                
                else if (controlador.vista.carPanel.getVelocidad()<18) {
                    controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()+4);
                	velocidadHilo=50;
                	if(velocidadGUI<40) velocidadGUI=velocidadGUI+10;
                }
                
                else if (controlador.vista.carPanel.getVelocidad()<36) {
                    controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()+2);
                	velocidadHilo=50;
                	if(velocidadGUI<60) velocidadGUI=velocidadGUI+10;
                }
                //else if (controlador.vista.carPanel.getVelocidad()<Car.VELOCIDAD_MAXIMA-28)
                  //  controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()+2);
               
                else if ((controlador.vista.carPanel.getVelocidad()<Car.VELOCIDAD_MAXIMA)&&(velocidadHilo%1==0)) {
                    controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()+1);
                    if(velocidadGUI<220) velocidadGUI=velocidadGUI+10;
                }
                
                else if((controlador.vista.carPanel.getVelocidad()==Car.VELOCIDAD_MAXIMA)&&(velocidadHilo%1==0)) {
                	if(velocidadGUI<220) velocidadGUI=velocidadGUI+10;
                	turbo = true;
                }
              
               
               
            }
            if (!controlador.vista.carPanel.isAcelerando()&&(controlador.vista.carPanel.getVelocidad()>0)) {
            	
            	
            	velocidadHilo=velocidadHilo+0.5;
            	if(controlador.vista.carPanel.getVelocidad()>50&&(velocidadHilo%11==0)) {
            	controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()-1);
            	velocidadGUI=velocidadGUI-10;
            	}
            	if(controlador.vista.carPanel.getVelocidad()<51&&(velocidadHilo%0.5==0)) {
            		if (velocidadGUI>=10&&(velocidadHilo%1.5==0))velocidadGUI=velocidadGUI-10;
            		else if(velocidadGUI<10)velocidadGUI=0;
                	controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()-1);
                	}
            	controlador.vista.pathPanel.moverCamino(nCamino);
            	
            	if(!(velocidadGUI==0&&(velocidadHilo%1==0))&&controlador.vista.carPanel.getVelocidad()>0) {
            	
                nCamino++;
                if (nCamino == 8)
                    nCamino = 0;
                
            	}
            	
            }

            // if(controlador.vista.carPanel.isFrenando());

            try {

                Thread.sleep(70-controlador.vista.carPanel.getVelocidad());

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
