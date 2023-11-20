package controlador;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputAxesDelta;
import com.github.strikerx3.jxinput.XInputButtons;
import com.github.strikerx3.jxinput.XInputButtonsDelta;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputComponentsDelta;
import com.github.strikerx3.jxinput.enums.XInputAxis;
import com.github.strikerx3.jxinput.enums.XInputButton;

import sprites.Car;
import vista.Vista;

public class HiloJuego implements Runnable {

    int nCamino = 0;
    Controlador controlador;
    static double velocidadHilo;
    public static int velocidadGUI, velocidadTurbo;
    static boolean turbo;

    public void run() {
        // TODO Auto-generated method stub

        while (true) {
        	
        	System.out.println(velocidadGUI);
        	System.out.println(controlador.vista.carPanel.getVelocidad());
        	System.out.println(velocidadTurbo);
        	
        	 if (controlador.device.poll()) {
        	    XInputComponents components = controlador.device.getComponents();
        	    XInputAxes axesComponents = components.getAxes();

        	    
        	 // Retrieve button state change
        	    if (axesComponents.rt>0) {
        	    	if (HiloJuego.velocidadGUI==220) controlador.vista.carPanel.ponerTurbo();
        	    }if (axesComponents.rt<=0) {
        	    	controlador.vista.carPanel.quitarTurbo();
            		if(HiloJuego.velocidadGUI==220&&!controlador.vista.carPanel.isFrenando()) {
            		controlador.vista.turbo.encender(true);
            		//controlador.vista.velocimetroSpeed.turbo(false);
            		}
        	    }
        	    if (axesComponents.lx<=-0.90&&axesComponents.lx>=-1.0) {
        	    	controlador.vista.carPanel.girarIzquierda();
        	    }
        	    if (axesComponents.lx>=0.90&&axesComponents.lx<=1.0) {
        	    	controlador.vista.carPanel.girarDerecha();
        	    }
        	    if (axesComponents.lx>=-0.10&&axesComponents.lx<=0.10) {
        	    	controlador.vista.carPanel.detenerIzquierda();
        	    	controlador.vista.carPanel.detenerDerecha();
        	    }
        	 }
        	
        	if (controlador.vista.carPanel.getVelocidad()==0&&velocidadGUI<10) {
        		controlador.vista.turbo.encender(false);
        		if (controlador.vista.carPanel.isFrenando()&&velocidadGUI==0)controlador.vista.carPanel.decelerar();
        		controlador.vista.velocimetroDigitos[0].setVisible(true);
        		controlador.vista.velocimetroDigitos[1].setVisible(false);
        		controlador.vista.velocimetroDigitos[2].setVisible(false);
        		controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI);
        	}
        	else if(velocidadGUI>=10&&velocidadGUI<100) {
        		controlador.vista.turbo.encender(false);
        		controlador.vista.velocimetroDigitos[0].setVisible(true);
        		controlador.vista.velocimetroDigitos[1].setVisible(true);
        		controlador.vista.velocimetroDigitos[2].setVisible(false);
        		if(velocidadGUI==10) controlador.vista.velocimetroDigitos[0].cambiarNumero(1);
        		else controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI/10);
        		controlador.vista.velocimetroDigitos[1].cambiarNumero(0);
        	}
        	else if(velocidadGUI>=100&&velocidadGUI<=220) {
        		
        		if (!controlador.vista.max.isVisible()) {
        			
        			controlador.vista.velocimetroDigitos[0].setVisible(true);
            		controlador.vista.velocimetroDigitos[1].setVisible(true);
            		controlador.vista.velocimetroDigitos[2].setVisible(true);
            		
        		}
        		
        		if(velocidadGUI<220) {
        			if(controlador.vista.max.isVisible()) controlador.vista.max.setVisible(false);
        			controlador.vista.velocimetroSpeed.turbo(false);
        			controlador.vista.turbo.encender(false);
        			
            		controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI/100);
            		controlador.vista.velocimetroDigitos[1].cambiarNumero((velocidadGUI/10)%10);
            		controlador.vista.velocimetroDigitos[2].cambiarNumero(0);
        		} else if ((velocidadGUI==220)&&controlador.vista.carPanel.isAcelerando()) {
        			
        			if (controlador.vista.carPanel.isFrenando()) {
        				
        				controlador.vista.turbo.encender(false);
        				controlador.vista.velocimetroSpeed.turbo(false);
                		controlador.vista.max.turbo(false);
                	}
        			
        			if ((velocidadHilo%10==0)&&(!controlador.vista.carPanel.isFrenando())) {
        				
        				controlador.vista.turbo.encender(true);
        				controlador.vista.velocimetroSpeed.turbo(true);
                		controlador.vista.max.turbo(true);
                		controlador.vista.velocimetroDigitos[0].turbo(true, 2);
                		controlador.vista.velocimetroDigitos[1].turbo(true, 2);
                		controlador.vista.velocimetroDigitos[2].turbo(true, 0);
                	}
                							
                	else if ((velocidadHilo%5==0)&&(!controlador.vista.carPanel.isFrenando())) {
                		
                		controlador.vista.turbo.encender(true);
                		controlador.vista.velocimetroSpeed.turbo(false);
                		controlador.vista.max.turbo(false);
                		controlador.vista.velocimetroDigitos[0].cambiarNumero(velocidadGUI/100);
                		controlador.vista.velocimetroDigitos[1].cambiarNumero((velocidadGUI/10)%10);
                		controlador.vista.velocimetroDigitos[2].cambiarNumero(0);
                	}
        		} else {
        		}
        		
        		
        		
        		
        		
        	} 
        	

            if (controlador.vista.carPanel.isGirandoIzquierda()&&controlador.vista.carPanel.getVelocidad()>0) {
            	if (velocidadTurbo>3) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (1 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            	else if (velocidadTurbo>2) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (2 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            	else if (velocidadTurbo>1) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (3 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            	else controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (3 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            }
                
            if (controlador.vista.carPanel.isGirandoDerecha()&&controlador.vista.carPanel.getVelocidad()>0) {
            	if (velocidadTurbo>3) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (1 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            	else if (velocidadTurbo>2) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (2 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            	else if (velocidadTurbo>1) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (3 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            	else controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (3 * Vista.reescalador),
                        controlador.vista.carPanel.getY());
            }
            if (controlador.vista.carPanel.isAcelerando()) {
            	
                controlador.vista.pathPanel.moverCamino(nCamino);
                nCamino++;
                if (nCamino == 8)
                    nCamino = 0;
                
                if (!controlador.vista.carPanel.isFrenando()) {
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
                	
                	/*if (velocidadGUI>=210) {
                		if ((velocidadHilo%5==0))
                		controlador.vista.velocimetroSpeed.turbo(true);
                		else if ((velocidadHilo%10==0))
                    		controlador.vista.velocimetroSpeed.turbo(false);
                	}*/
                }
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
            
            if (controlador.vista.carPanel.isFrenando()&&(controlador.vista.carPanel.getVelocidad()>0)) {
            	
            	if (velocidadTurbo>0)velocidadTurbo--;
            	if(velocidadGUI==220) {
            		controlador.vista.velocimetroDigitos[0].cambiarNumero(2);
            		controlador.vista.velocimetroDigitos[1].cambiarNumero(2);
            		controlador.vista.velocimetroDigitos[2].cambiarNumero(0);
            	}
            	
            	controlador.vista.max.setVisible(false);
            	controlador.vista.turbo.encender(false);
            	controlador.vista.max.turbo(false);
            	controlador.vista.velocimetroSpeed.turbo(false);
            	
            	
            	if (controlador.vista.carPanel.isTurbo()) {
            	if (velocidadTurbo>0)velocidadTurbo--;
            	controlador.vista.velocimetroSpeed.turbo(false);
            	controlador.vista.max.setVisible(false);
            	//controlador.vista.velocimetroDigitos[0].setVisible(true);
            	//controlador.vista.velocimetroDigitos[1].setVisible(true);
            	//controlador.vista.velocimetroDigitos[2].setVisible(true);
            	 }
            	
            	else if(controlador.vista.carPanel.getVelocidad()>50&&(velocidadHilo%5==0)) {
            	controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()-1);
            	velocidadGUI=velocidadGUI-20;
            	}
            	 else if(controlador.vista.carPanel.getVelocidad()<51&&(velocidadHilo%0.5==0)) {
            		if (velocidadGUI>=10&&(velocidadHilo%1.5==0))velocidadGUI=velocidadGUI-20;
            		else if(velocidadGUI<10)velocidadGUI=0;
                	controlador.vista.carPanel.setVelocidad(controlador.vista.carPanel.getVelocidad()-1);
                	}
            	
            	 controlador.vista.pathPanel.moverCamino(nCamino);
            }
            
            if(!controlador.vista.carPanel.isFrenando()) {
            
            if (controlador.vista.carPanel.isTurbo()&&controlador.vista.turbo.pulsado) {
            	controlador.vista.velocimetroDigitos[0].setVisible(false);
            	controlador.vista.velocimetroDigitos[1].setVisible(false);
            	controlador.vista.velocimetroDigitos[2].setVisible(false);
            	controlador.vista.max.setVisible(true);
            	controlador.vista.turbo.pulsar(true);
            	if (velocidadTurbo<6&&velocidadHilo%2==0)velocidadTurbo++;
            }
            else if (!controlador.vista.carPanel.isTurbo()&&velocidadGUI==220) {
            	controlador.vista.max.setVisible(false);
            	//controlador.vista.turbo.encender(true);
            	if (velocidadTurbo>0&&velocidadHilo%2==0)velocidadTurbo--;
            }
            }

            // if(controlador.vista.carPanel.isFrenando());

            try {

                Thread.sleep((70-controlador.vista.carPanel.getVelocidad()-velocidadTurbo));

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
