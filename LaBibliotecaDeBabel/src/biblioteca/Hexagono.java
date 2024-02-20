package biblioteca;

import java.util.ArrayList;

public class Hexagono {
	
	//de los 6 lados, 4 contienen cinco anaqueles; (los otros 2 sirven para pasar a un hexágono contiguo).
	//es decir, en la práctica cada hexágono tiene 4 lados.
	
	private static final int CANTIDAD_LADOS =4;
	private int numeroPlanta;
	private int numeroHexagono;
	protected String id; //id = planta-hexagono
	private ArrayList<LadoHexagono> ladosHexagono;
	private Biblioteca biblioteca;
	
	public Hexagono(Biblioteca biblioteca, int numeroPlanta, int numeroHexagono) {
		this.biblioteca=biblioteca;
		this.numeroHexagono=numeroHexagono;
		this.numeroPlanta=numeroPlanta;
		this.id=numeroPlanta+"-"+numeroHexagono;
		this.ladosHexagono  = new ArrayList<LadoHexagono>();
		for (int i=0; i<CANTIDAD_LADOS; i++) {
			this.ladosHexagono.add(new LadoHexagono(this, i+1));
		}
	}

	public ArrayList<LadoHexagono> getLadosHexagono() {
		return ladosHexagono;
	}
	
	

}
