package ej01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		
		int tamanno=100;
		List<Integer> listaNumeros = new ArrayList<Integer>();
		
		for (int i=0; i<tamanno; i++) {
			Random random = new Random();
			listaNumeros.add(random.nextInt(1000) + 1);
		}
		
		System.out.println(listaNumeros);
		
		Predicate<Integer> esPrimo = (numero) -> { if (numero <= 1) //Predicate porque recibe un argumento y retorna un boolean
	       
		return false;
	    
	    for (int i = 2; i <= Math.sqrt(numero); i++) {
	    	
	    	/*
	    	 * si un número tiene un divisor mayor que su raíz cuadrada, 
	    	 * también debe tener un divisor menor que su raíz cuadrada. 
	    	 * Por lo tanto, si no hay divisores menores o iguales a la 
	    	 * raíz cuadrada de un número, no habrá divisores mayores, 
	    	 * lo que confirma que el número es primo.
	    	 * */
	    	
	        if (numero % i == 0) {
	            return false;
	        }
	    }
	    return true;
	    
		};
		
		List<Integer> listaPrimos = listaNumeros.stream().filter(esPrimo).collect(Collectors.toList());
		System.out.println("Primos: "+listaPrimos);
		
		
	}

}
