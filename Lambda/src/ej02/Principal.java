package ej02;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		
		List<String> nombres = Arrays.asList("Juan", "María", "Carlos", "Sofía", "Luis", "Ana", "David", "Laura", "Diego", "Elena", "Fernando", "Isabel", "Gabriel", "Carmen", "Javier", "Lucía", "Miguel", "Natalia", "Pedro", "Raquel");
		
		List<Integer> longitudNombres = nombres.stream()
				 .map((nombre) -> nombre.length())
				 .collect(Collectors.toList());
		
		Map<String, Integer> mapaNombres = new LinkedHashMap<>();
		
		for (int i = 0; i < nombres.size(); i++) {
            mapaNombres.put(nombres.get(i), longitudNombres.get(i));
        }

        // Imprimir el HashMap
        System.out.println(mapaNombres);
	}

}
