package Práctica8.Ejercicio2;

import java.util.concurrent.ForkJoinPool;

public class OrdenarMezclaForkJoin {

    private int nProcessors;

    public OrdenarMezclaForkJoin(int nProcessors) {
        this.nProcessors = nProcessors;
    }

    public void ordena(Integer[] a) {
        Integer[] auxiliar = new Integer[a.length];
        ForkJoinPool forkJoinPool = new ForkJoinPool(nProcessors);
        forkJoinPool.invoke(new OrdenarMezclaTask(a, auxiliar, 0, a.length-1));
    }

    public static void main(String args[]) {
        Integer[] a = new Integer[]{8, 1, 5, 4, 6, 7, 3, 2, 8, 1, 5, 4, 6, 7, 3, 2, 8, 1, 5, 4, 6, 7, 3, 2};
        int nProcessors = Runtime.getRuntime().availableProcessors();
        OrdenarMezclaForkJoin mergeSort = new OrdenarMezclaForkJoin(nProcessors);
        mergeSort.ordena(a);
        for(int i=0; i<a.length;i++) {
            System.out.println(a[i]);
        }
    }
}

