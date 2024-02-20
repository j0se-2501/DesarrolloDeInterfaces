package biblioteca;

public class Principal {

	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca(10000);
		biblioteca.buscarLibroPorId("1-1-1-1-1");
		biblioteca.buscarLibroPorId("75-75-4-5-32");
		biblioteca.buscarLibroPorPalabraEnTexto("yeray");
		biblioteca.buscarLibroPorPalabraEnTexto("lol");
	}

}
