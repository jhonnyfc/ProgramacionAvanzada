package Práctica8.Ejercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PruebasRendimiento {

	private static Random r = new Random();

	private static Integer[] generaArrayAleatorio(int size) {
		Integer[] array = new Integer[size];
		for (int i = 0; i < size; i++) {
			array[i] = generaIntegerAleatorio();
		}
		return array;
	}

	private static Integer generaIntegerAleatorio() {
		return r.nextInt(200_000) - 100_000;
	}

	public static void main(String args[]) {
		int nProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("nProcessors = " + nProcessors);

		List<Integer> arraySizes = Arrays.asList(50, 100, 250, 500, 10, 5, 3, 2);
		for (Integer arraySize : arraySizes) {

			System.out.println("ArraySize: " + arraySize);

			for (int i = 0; i < 3; i++) {
				Integer[] integers = generaArrayAleatorio(arraySize);
				Integer[] copiaIntegers = integers.clone();

				long t = System.currentTimeMillis();
				OrdenarMezcla secuencial = new OrdenarMezcla();
				secuencial.ordena(integers);

				System.out.println("\tSecuencial: " + (System.currentTimeMillis() - t));

				t = System.currentTimeMillis();
				OrdenarMezclaForkJoin paralelo = new OrdenarMezclaForkJoin(nProcessors);
				paralelo.ordena(copiaIntegers);

				System.out.println("\tParalelo: " + (System.currentTimeMillis() - t));

			}
		}
	}
}
