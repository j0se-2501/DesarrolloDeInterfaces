package principal;

import vista.Vista;

/**
 * La clase Principal contiene el método principal (main) que inicia la aplicación.
 */
public class Principal {
	
    /**
     * El método principal de la aplicación.
     * Crea una instancia de la clase Vista y muestra la ventana principal.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase Vista
        Vista ventana = new Vista();
        
        // Hacer visible la ventana principal
        ventana.setVisible(true);
    }
}

