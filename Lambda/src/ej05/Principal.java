package ej05;

import java.util.ArrayList;
import java.util.List;

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
		
		List<Integer> sublista1 = new ArrayList<Integer>();
		List<Integer> sublista2 = new ArrayList<Integer>();
		List<Integer> sublista3 = new ArrayList<Integer>();
		List<Integer> sublista4 = new ArrayList<Integer>();
		
		for (int numero : listaNumeros) {
			
			if ((listaNumeros.indexOf(numero)>=0)&&(listaNumeros.indexOf(numero)<=24)) sublista1.add(numero);
			else if ((listaNumeros.indexOf(numero)>=25)&&(listaNumeros.indexOf(numero)<=49)) sublista2.add(numero);
			else if ((listaNumeros.indexOf(numero)>=50)&&(listaNumeros.indexOf(numero)<=74)) sublista3.add(numero);
			else if ((listaNumeros.indexOf(numero)>=75)&&(listaNumeros.indexOf(numero)<=299)) sublista4.add(numero);
			
		}
		
		System.out.println(sublista1);
		System.out.println(sublista2);
		System.out.println(sublista3);
		System.out.println(sublista4);
		
		
	}

}
