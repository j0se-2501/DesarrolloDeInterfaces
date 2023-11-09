package ej03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Controlador {
	
	public Vista vista;
	Timer timer = new Timer();
	
	
	public Controlador(Vista vDesactivar) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por parámetro
        // en el constructor de esta clase
        this.vista=vDesactivar;
    }
	
	public void escucharEventos() {
		
		vista.botonReanudar.addActionListener(e -> {
	        vista.botonReanudar.setVisible(false);
	        vista.botonDetener.setVisible(true);
	        arrancarTimer();
	    });
		vista.botonDetener.addActionListener(e -> {
	        vista.botonDetener.setVisible(false);
	        vista.botonReanudar.setVisible(true);
	        timer.cancel();
	    });
		
	}
	
	public void arrancarTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Actualiza el textoHora con el valor retornado por horaActualFormateada()
                vista.textoHora.setText(horaActualFormateada());
                
                // Imprime el textoHora para verificar que se actualiza cada segundo
                
            }
        }, 0, 1000);
	}
		
	
	public String horaActualFormateada() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));
        
        String nombreMes;
        
        switch (date.getMonth()+1) {
            case 1:
                nombreMes = "enero";
                break;
            case 2:
                nombreMes = "febrero";
                break;
            case 3:
                nombreMes = "marzo";
                break;
            case 4:
                nombreMes = "abril";
                break;
            case 5:
                nombreMes = "mayo";
                break;
            case 6:
                nombreMes = "junio";
                break;
            case 7:
                nombreMes = "julio";
                break;
            case 8:
                nombreMes = "agosto";
                break;
            case 9:
                nombreMes = "septiembre";
                break;
            case 10:
                nombreMes = "octubre";
                break;
            case 11:
                nombreMes = "noviembre";
                break;
            case 12:
                nombreMes = "diciembre";
                break;
            default:
                nombreMes = "Mes inválido";
                break;
        }
        
        return "Son las "+date.getHours()+":"+String.format("%02d", date.getMinutes())+":"+String.format("%02d", date.getSeconds())+" del "+date.getDate()+" de " +nombreMes+ " del "+(date.getYear()+1900);
		
	}

}
