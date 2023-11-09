package ej04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Principal {

	public static void main(String[] args) {
		
		Map<String, BigDecimal> mapaFrutas = new LinkedHashMap<>(); //he cogido bigdecimal porque dijo en la charla este hombre que
																	//los bancos trabajaban con el dinero con bigdecimal
																	//me ha resultado mas dificil trabajar que con double
		
		try (BufferedReader br = new BufferedReader(new FileReader("csv/frutas.csv"))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                //divido el csv en dos partes separadas por comas 
                String[] columnas = linea.split(",");
                String fruta = columnas[0].trim();
                BigDecimal precio = new BigDecimal(columnas[1].trim());
                //agrego cada columna al mapa
                mapaFrutas.put(fruta, precio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println(mapaFrutas);
		
		Function <Map<String, BigDecimal>, Double> media = (lista) -> lista.values().stream().mapToDouble(BigDecimal::doubleValue).average().getAsDouble();
		//a una funcion le meto el mapa y la salida, en formato double, al no poder bigdecimal
		//de ese mapa cojo los valores, hago el stream, los paso a Double, hago la media y cojo el Double (si no pongo esto, no funciona pues se queda como optionalDouble?)
		
		System.out.println("Media: "+String.format("%.2f", media.apply(mapaFrutas))); //formato de dos decimales

	}

}
