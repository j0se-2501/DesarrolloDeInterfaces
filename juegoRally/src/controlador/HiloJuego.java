package controlador;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sprites.Car;
import vista.Vista;

public class HiloJuego implements Runnable {

    int nCamino = 0;
    Controlador controlador;
    static double velocidadHilo;
    public static int velocidadGUI, velocidadTurbo, estadoGiro;
    static boolean turbo, gameOver=false, finish=false;
    AudioInputStream audioInputStream;
    Clip clip;

    public void run() {
        // TODO Auto-generated method stub

        while (!gameOver&&!finish) {
        	
        	//SYSOS DE COMPROBACION
        	
        	//System.out.println(velocidadGUI);
        	System.out.println(controlador.vista.carPanel.getVelocidad());
        	System.out.println(velocidadTurbo);
        	System.out.println(estadoGiro);
        	
        	//SONIDO MOTOR
        	
        	try {
        		
        	//clip = AudioSystem.getClip();
			
        	if (clip!=null) {
        		clip.stop();
        		clip.close();
        	}
        	
        	if (velocidadGUI>=0&&velocidadGUI%2==0) audioInputStream = AudioSystem.getAudioInputStream(new File("src/sfx/carEngine"+velocidadGUI/2+".wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
	        clip.start();
			
			
        	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	//CONTROLES MANDO
        	
        	
        	 if (controlador.device.poll()&&controlador.teclado==false) {
        		 
        		 controlador.controlesMando2();
        	    
        	 }
        	 
        	 //HUD VELOCIDAD
        	
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
        				}
        			} 
        	
        	//FISICAS
        	//GIRO IZQUIERDA Y DERECHA
        	
            if (controlador.vista.carPanel.isGirandoIzquierda()&&controlador.vista.carPanel.getVelocidad()>0&&controlador.vista.carPanel.getX()>-10*Vista.reescalador) {
            	if (velocidadTurbo>3||(estadoGiro>=0&&estadoGiro<8)) {
            		controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (1 * Vista.reescalador), controlador.vista.carPanel.getY());
            		if (estadoGiro<8) estadoGiro++;
            		}
            	else if (velocidadTurbo>2 || (estadoGiro>=8&&estadoGiro<16)) {
            		controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (2 * Vista.reescalador), controlador.vista.carPanel.getY());
            		if (estadoGiro<16) estadoGiro++;
            	}
            	else if (velocidadTurbo>1 ||estadoGiro==16) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (3 * Vista.reescalador), controlador.vista.carPanel.getY());
            	else controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() - (3 * Vista.reescalador), controlador.vista.carPanel.getY());
            }
                
            if (controlador.vista.carPanel.isGirandoDerecha()&&controlador.vista.carPanel.getVelocidad()>0&&controlador.vista.carPanel.getX()<230*Vista.reescalador) {
            	if (velocidadTurbo>3||(estadoGiro>=0&&estadoGiro<8)) {
            		controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (1 * Vista.reescalador), controlador.vista.carPanel.getY());
            		if (estadoGiro<8)estadoGiro++;
            	}
                        
            	else if (velocidadTurbo>2||(estadoGiro>=8&&estadoGiro<16)) {
            		controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (2 * Vista.reescalador), controlador.vista.carPanel.getY());
            		if (estadoGiro<16)estadoGiro++;
            	}
                        
            	else if (velocidadTurbo>1 ||estadoGiro==16) controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (3 * Vista.reescalador), controlador.vista.carPanel.getY());
            	else controlador.vista.carPanel.setLocation(controlador.vista.carPanel.getX() + (3 * Vista.reescalador), controlador.vista.carPanel.getY());
            	}
            
            //ACELERACION
            
            if (controlador.vista.carPanel.isAcelerando()) {
            	
                controlador.vista.pathPanel.moverCamino(nCamino);
                controlador.vista.arbolLeft0.moverArbolesLeft(nCamino);
                controlador.vista.arbolLeft0.moverArbolesRight(nCamino);
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
            
            
            //DECELERACION
            
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
            	controlador.vista.arbolLeft0.moverArbolesLeft(nCamino);
            	controlador.vista.arbolLeft0.moverArbolesRight(nCamino);
            	
            	if (velocidadTurbo>0&&velocidadHilo%4==0)velocidadTurbo--;
            	
            	if(!(velocidadGUI==0&&(velocidadHilo%1==0))&&controlador.vista.carPanel.getVelocidad()>0) {
            	
                nCamino++;
                if (nCamino == 8)
                    nCamino = 0;
                
            	}
            	
            }
            
            
            //FRENADA
            
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
            	 controlador.vista.arbolLeft0.moverArbolesLeft(nCamino);
            	 controlador.vista.arbolLeft0.moverArbolesRight(nCamino);
            }
            
            //TURBO
            
            if(!controlador.vista.carPanel.isFrenando()) {
            
            if (controlador.vista.carPanel.isTurbo()&&controlador.vista.turbo.pulsado) {
            	controlador.vista.velocimetroDigitos[0].setVisible(false);
            	controlador.vista.velocimetroDigitos[1].setVisible(false);
            	controlador.vista.velocimetroDigitos[2].setVisible(false);
            	controlador.vista.max.setVisible(true);
            	controlador.vista.turbo.pulsar(true);
            	if (velocidadTurbo<6&&velocidadHilo%2==0)velocidadTurbo++;
            }
            else if (!controlador.vista.carPanel.isTurbo()&&velocidadGUI<=220) {
            	controlador.vista.max.setVisible(false);
            	//controlador.vista.turbo.encender(true);
            	if (velocidadTurbo>0&&velocidadHilo%2==0)velocidadTurbo--;
            }
            }

            // if(controlador.vista.carPanel.isFrenando());
            
            //VELOCIDAD DEL HILO

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
