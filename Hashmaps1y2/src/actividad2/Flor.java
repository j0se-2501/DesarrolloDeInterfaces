package actividad2;

import java.util.HashMap;
import java.util.Iterator;

import actividad1.Estudiante;

public class Flor {
	
	private static int contador = 0;
	public static HashMap <Integer, Flor> mapaFlorId = new HashMap<>();
	
	//atributos
	
	private int id;
	private String nombre;
	private double precio;
	private int stock;
	
	//getters y setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//constructores
	
	public Flor(String nombre, double precio, int stock) {
		super();
		this.id = contador++;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Flor() {
		
	}
	
	//metodos
	
	public void floresPorDefecto() {
		
		contador = 0;
		
		mapaFlorId.clear();
		
		String[] nombres = {"Rosa", "Amapola", "Tulipán", "Lirio", "Margarita",
                "Orquídea", "Girasol", "Clavel", "Dalia", "Peonía",
                "Lavanda", "Jazmín", "Narciso", "Petunia", "Hortensia",
                "Crótalo", "Begonia", "Caléndula", "Camelia", "Diente de León"};

		//Creo 20 flores utilizando nombres reales y otros valores aleatorios
		
		for (int i = 0; i < 20; i++) {
			double precio = 10.0 + Math.random() * 20; // Precio aleatorio entre 10.0 y 30.0
			int stock = (int) (Math.random() * 101); // Stock aleatorio entre 0 y 99
			Flor flor = new Flor(nombres[i % nombres.length], precio, stock);
			mapaFlorId.put(flor.getId(), flor);
			}

	}
	
	public static void annadirFlor(String nombre, double precio, int stock) {
		Flor flor = new Flor(nombre, precio, stock);
		mapaFlorId.put(flor.getId(), flor);
	}
	
	public static void editarFlor(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
		Iterator<HashMap.Entry<Integer, Flor>> iterator = mapaFlorId.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Flor> entry = iterator.next();
            int idFlor = entry.getKey();
            Flor flor = entry.getValue();

            //compruebo si el ID coincide con el ID proporcionado
            if (idFlor == id) {
                //cambio el nombre y la nota del estudiante
                flor.setNombre(nuevoNombre);
                flor.setPrecio(nuevoPrecio);
                flor.setStock(nuevoStock);
                mapaFlorId.put(idFlor, flor);
                return; //salgo del bucle
            }
        }
		
	}
	
	public static void eliminarFlor(int id) { //igual que editar pero con el metodo remove
		Iterator<HashMap.Entry<Integer, Flor>> iterator = mapaFlorId.entrySet().iterator();
        while (iterator.hasNext()) {
        	HashMap.Entry<Integer, Flor> entry = iterator.next();
        	int idFlor = entry.getKey();
            Flor flor = entry.getValue();

            if (idFlor == id) {
                
                mapaFlorId.remove(idFlor, flor);
                return;
            }
        }
		
	}
	
	

}
