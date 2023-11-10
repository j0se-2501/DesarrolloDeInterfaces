package ej05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		
		/*
		Dada una lista grande de números enteros, divide la lista en varias partes y, utilizando
		Streams y funciones lambda, calcula la suma de cada parte en paralelo.
		Muestra los resultados parciales.
		Muestra el resultado de la suma de los resultados parciales.
		*/
		
		int tamanno=100;
		List<Integer> listaNumeros = new ArrayList<Integer>();

		ej01.Principal.annadirRandomsALista(listaNumeros, tamanno);
		
		List<Integer> sublista1 = listaNumeros.parallelStream()
				 .filter(numero -> (listaNumeros.indexOf(numero)>=0)&&(listaNumeros.indexOf(numero)<=24))
				 .collect(Collectors.toList());
		List<Integer> sublista2 = listaNumeros.parallelStream()
				 .filter(numero -> (listaNumeros.indexOf(numero)>=25)&&(listaNumeros.indexOf(numero)<=49))
				 .collect(Collectors.toList());
		List<Integer> sublista3 = listaNumeros.parallelStream()
				 .filter(numero -> (listaNumeros.indexOf(numero)>=50)&&(listaNumeros.indexOf(numero)<=74))
				 .collect(Collectors.toList());
		List<Integer> sublista4 = listaNumeros.parallelStream()
				 .filter(numero -> (listaNumeros.indexOf(numero)>=75)&&(listaNumeros.indexOf(numero)<=99))
				 .collect(Collectors.toList());
		
		int sumaSublista1 = sublista1.parallelStream()
				 .mapToInt(Integer::intValue)
				 .sum();
		int sumaSublista2 = sublista2.parallelStream()
				 .mapToInt(Integer::intValue)
				 .sum();
		int sumaSublista3 = sublista3.parallelStream()
				 .mapToInt(Integer::intValue)
				 .sum();
		int sumaSublista4 = sublista4.parallelStream()
				 .mapToInt(Integer::intValue)
				 .sum();
		
		System.out.println("Lista: "+listaNumeros+
				"\n\nSublista 1: "+sublista1+
				"\nTotal sublista 1: "+sumaSublista1+
				"\n\nSublista 2: "+sublista2+
				"\nTotal sublista 2: "+sumaSublista2+
				"\n\nSublista 3: "+sublista3+
				"\nTotal sublista 3: "+sumaSublista3+
				"\n\nSublista 4: "+sublista4+
				"\nTotal sublista 4: "+sumaSublista4+
				"\n\nTotal de todas las listas: "+(sumaSublista1+sumaSublista2+sumaSublista3+sumaSublista4));
		
	}

}
