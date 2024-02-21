package biblioteca;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Biblioteca {
	
	//existiran el mismo numero de plantas que de hexagonos en cada planta
	//el tamanno total de hexágonos está por definir
	
	private int tamanno;
	private ArrayList<ArrayList<Hexagono>> plantas;
	
	public Biblioteca(int tamanno) {
		
		this.tamanno=tamanno;
		this.plantas=new ArrayList<ArrayList<Hexagono>>();
		for (int i=0; i<this.tamanno/Math.sqrt(tamanno); i++) {
			plantas.add(new ArrayList<Hexagono>());
			for (int j=0; j<this.tamanno/Math.sqrt(tamanno); j++) {
				plantas.get(i).add(new Hexagono(this, i+1, j+1));
			}
		}
		
	}
	
	public void buscarLibroPorId(String id) {
        for (ArrayList<Hexagono> planta : plantas) {
            for (Hexagono hexagono : planta) {
                for (LadoHexagono lado : hexagono.getLadosHexagono()) {
                    for (Anaquel anaquel : lado.getAnaqueles()) {
                        for (Libro libro : anaquel.getLibros()) {
                            if (libro.getId().equals(id)) {
                                System.out.println(libro.getId());
                                System.out.println("\n" + libro.getTexto());
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Libro no encontrado.");
    }
	
	

	public void buscarLibroPorPalabraEnTexto(String palabra) {
	    Pattern pattern = Pattern.compile("\\b" + Pattern.quote(palabra) + "\\b");

	    for (ArrayList<Hexagono> planta : plantas) {
	        for (Hexagono hexagono : planta) {
	            for (LadoHexagono lado : hexagono.getLadosHexagono()) {
	                for (Anaquel anaquel : lado.getAnaqueles()) {
	                    for (Libro libro : anaquel.getLibros()) {
	                        if (libro.getTexto().contains(palabra)) {
	                            System.out.println(libro.getId()+" contiene: "+palabra);
	                            System.out.println("\n" + libro.getTexto());
	                         }
	                    }
	                }
	            }
	        }
	    }
	    System.out.println("Libro no encontrado.");
	}


}
