package Práctica8.Ejercicio2;

public class OrdenarMezcla {

	public void ordena(Integer[] a) {
		Integer[] auxiliar = new Integer[a.length];
		ordenar_mezcla(a, auxiliar, 0, a.length - 1);
	}

	private void ordenar_mezcla(Integer[] a, Integer[] auxiliar, int inf, int sup) {
		if (inf < sup) {
			int medio = inf + (sup - inf) / 2;
			ordenar_mezcla(a, auxiliar, inf, medio);
			ordenar_mezcla(a, auxiliar, medio + 1, sup);
			mezcla(a, auxiliar, inf, medio, sup);
		}
	}

	private void mezcla(Integer[] a, Integer[] auxiliar, int inf, int medio, int sup) {
		int i_l = inf;
		int i_r = medio + 1;
		for (int k = inf; k <= sup; k++) {
			if (i_l == medio + 1) {
				auxiliar[k] = a[i_r];
				i_r++;
			} else if (i_r == sup + 1) {
				auxiliar[k] = a[i_l];
				i_l++;
			} else if (esMenor(a[i_l], a[i_r])) {
				auxiliar[k] = a[i_l];
				i_l++;
			} else {
				auxiliar[k] = a[i_r];
				i_r++;
			}
		}
		for (int k = inf; k <= sup; k++) {
			a[k] = auxiliar[k];
		}
	}

	private boolean esMenor(Integer l, Integer r) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return l < r;
	}

	public static void main(String args[]) {
		Integer[] a = new Integer[] { 8, 1, 5, 4, 6, 7, 3, 2 };
		OrdenarMezcla mergeSort = new OrdenarMezcla();
		mergeSort.ordena(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
