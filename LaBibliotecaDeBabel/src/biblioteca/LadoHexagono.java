package biblioteca;

import java.util.ArrayList;

public class LadoHexagono {
	
	//cada lado del hexágono contiene 5 anaqueles
	
	private static final int CANTIDAD_ANAQUELES =5;
	private int numero;
	protected String id; // id=planta-hexagono-ladohexagono (1-4 lados por hexagono)
	private ArrayList<Anaquel> anaqueles = new ArrayList<Anaquel>();
	private Hexagono hexagono;
	
	public LadoHexagono(Hexagono hexagono, int numero) {
		this.numero=numero;
		this.id=hexagono.id+"-"+numero;
		this.hexagono = hexagono;
		this.anaqueles = new ArrayList<Anaquel>();
		for (int i=0; i<CANTIDAD_ANAQUELES; i++) {
			anaqueles.add(new Anaquel(this, i+1));
		}
	}

	public ArrayList<Anaquel> getAnaqueles() {
		return anaqueles;
	}
	
	
	
}
