package actividad1;

import java.util.HashMap;
import java.util.Iterator;

public class Estudiante {
	
	
	private static int contador = 0;
	public static HashMap <Estudiante, Double> mapaAlumnosNota = new HashMap<>();
	
	//atributos
	
	private int id;
	private String nombre;
	private double nota;
	
	//getters y setters
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	//constructores
	
	public Estudiante(String nombre, double nota) {
		super();
		this.id = contador++;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public Estudiante(String nombre) {
		super();
		this.id = contador++;
		this.nombre = nombre;
	}
	
	public Estudiante() {
		super();
	}
	
	//metodos
	
	public static void estudiantesPorDefecto() {
		
		contador=0; //reseteo el contador a 0 para volver a contar las id desde 0
		
		mapaAlumnosNota.clear(); //vacio el mapa
		
		Estudiante estudiante1 = new Estudiante("Gomez Hernandez, Pepito", 7.50);
		Estudiante estudiante2 = new Estudiante("Fernandez Garcia, Laura", 5.20);
		Estudiante estudiante3 = new Estudiante("Gutierrez Perez, Alberto", 10.00);
		Estudiante estudiante4 = new Estudiante("Martinez Lopez, Juan", 8.30);
		Estudiante estudiante5 = new Estudiante("Rodriguez Sanchez, Maria", 6.70);
		Estudiante estudiante6 = new Estudiante("Diaz Ramirez, Carlos", 9.20);
		Estudiante estudiante7 = new Estudiante("Lopez Gonzalez, Ana", 4.80);
		Estudiante estudiante8 = new Estudiante("Sanchez Torres, Javier", 6.90);
		Estudiante estudiante9 = new Estudiante("Torres Diaz, Elena", 8.10);
		Estudiante estudiante10 = new Estudiante("Hernandez Ruiz, Miguel", 9.70);
		Estudiante estudiante11 = new Estudiante("Gomez Garcia, Jose Antonio", 6.50);
		Estudiante estudiante12 = new Estudiante("Fernandez Garcia, Clara", 3.20);
		Estudiante estudiante13 = new Estudiante("Gutierrez Fernandez, Francisco", 10.00);
		Estudiante estudiante14 = new Estudiante("Martinez Rodriguez, Jose Ramon", 7.30);
		Estudiante estudiante15 = new Estudiante("Rodriguez Martinez, Nerea", 8.70);
		Estudiante estudiante16 = new Estudiante("Martinez Lopez, Adrian", 8.20);
		Estudiante estudiante17 = new Estudiante("Lopez Diaz, Ana", 5.80);
		Estudiante estudiante18 = new Estudiante("Ruiz Torres, Mario", 7.90);
		Estudiante estudiante19 = new Estudiante("Torres Sanchez, Jacinta", 7.10);
		Estudiante estudiante20 = new Estudiante("Hernandez Ruiz, Adolfo", 9.70);
		
		mapaAlumnosNota.put(estudiante1, estudiante1.getNota());
        mapaAlumnosNota.put(estudiante2, estudiante2.getNota());
        mapaAlumnosNota.put(estudiante3, estudiante3.getNota());
        mapaAlumnosNota.put(estudiante4, estudiante4.getNota());
        mapaAlumnosNota.put(estudiante5, estudiante5.getNota());
        mapaAlumnosNota.put(estudiante6, estudiante6.getNota());
        mapaAlumnosNota.put(estudiante7, estudiante7.getNota());
        mapaAlumnosNota.put(estudiante8, estudiante8.getNota());
        mapaAlumnosNota.put(estudiante9, estudiante9.getNota());
        mapaAlumnosNota.put(estudiante10, estudiante10.getNota());
        mapaAlumnosNota.put(estudiante11, estudiante11.getNota());
        mapaAlumnosNota.put(estudiante12, estudiante12.getNota());
        mapaAlumnosNota.put(estudiante13, estudiante13.getNota());
        mapaAlumnosNota.put(estudiante14, estudiante14.getNota());
        mapaAlumnosNota.put(estudiante15, estudiante15.getNota());
        mapaAlumnosNota.put(estudiante16, estudiante16.getNota());
        mapaAlumnosNota.put(estudiante17, estudiante17.getNota());
        mapaAlumnosNota.put(estudiante18, estudiante18.getNota());
        mapaAlumnosNota.put(estudiante19, estudiante19.getNota());
        mapaAlumnosNota.put(estudiante20, estudiante20.getNota());
		
	}

	public static void annadirEstudiante(String nombre, double nota) {
		Estudiante estudiante = new Estudiante(nombre, nota);
		mapaAlumnosNota.put(estudiante, nota);
	}
	
	public static void editarEstudiante(int id, String nuevoNombre, double nuevaNota) {
		Iterator<HashMap.Entry<Estudiante, Double>> iterator = mapaAlumnosNota.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Estudiante, Double> entry = iterator.next();
            Estudiante estudiante = entry.getKey();

            //compruebo si el ID coincide con el ID proporcionado
            if (estudiante.getId() == id) {
                //cambio el nombre y la nota del estudiante
                estudiante.setNombre(nuevoNombre);
                estudiante.setNota(nuevaNota);
                mapaAlumnosNota.put(estudiante, nuevaNota);
                return; //salgo del bucle
            }
        }
		
	}
	
	public static void eliminarEstudiante(int id) { //igual que editar pero con el metodo remove
		Iterator<HashMap.Entry<Estudiante, Double>> iterator = mapaAlumnosNota.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Estudiante, Double> entry = iterator.next();
            Estudiante estudiante = entry.getKey();

            if (estudiante.getId() == id) {
                
                mapaAlumnosNota.remove(estudiante, estudiante.getNota());
                return;
            }
        }
		
	}
	
}

