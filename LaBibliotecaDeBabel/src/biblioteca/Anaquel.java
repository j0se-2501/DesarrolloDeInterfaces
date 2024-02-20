package biblioteca;

import java.util.ArrayList;

public class Anaquel {
	
	//cada anaquel contiene 32 libros
	
	private static final int CANTIDAD_LIBROS = 32;
	protected String id; // id=planta-hexagono-ladohexagono-anaquel (1-5 anaqueles por lado)
	private int numero;
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private LadoHexagono ladoHexagono;
	
	public Anaquel(LadoHexagono ladoHexagono, int numero) {
		this.ladoHexagono=ladoHexagono;
		this.numero=numero;
		this.id=ladoHexagono.id+"-"+numero;
		libros = new ArrayList<Libro>();
		for (int i=0; i<CANTIDAD_LIBROS; i++) {
			libros.add(new Libro(this, i+1));
		}
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	
	
}
