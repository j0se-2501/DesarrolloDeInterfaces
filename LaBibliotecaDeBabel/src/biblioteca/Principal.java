package biblioteca;

public class Principal {

	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca(12321);
		biblioteca.buscarLibroPorId("1-1-1-1-1");
		biblioteca.buscarLibroPorId("111-111-4-5-32");
		biblioteca.buscarLibroPorPalabraEnTexto("anime");
		biblioteca.buscarLibroPorPalabraEnTexto("pepelu");
	}

}
