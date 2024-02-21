package biblioteca;

import java.util.ArrayList;

public class Libro {
    private static int contId = 0;
    private int numero;
    protected String id;
    private Anaquel anaquel;
    private String texto;
    private char[] caracter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ',', '.'};

    public Libro(Anaquel anaquel, int numero) {
        super();

        this.numero = numero;
        this.id = anaquel.id + "-" + numero;
        this.anaquel = anaquel;
        this.texto = generarTextoAleatorio();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getId() {
		return id;
	}

	public String generarStringAleatorio(int longitud) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int index = (int) (Math.random() * caracter.length);
            sb.append(caracter[index]);
            if ((i + 1) % 28 == 0 && i != 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String generarTextoAleatorio() {
        return generarStringAleatorio(280);
    }
}

