
package p8_paralelizacion;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author rabiixx
 */
public class MergeSortThread extends RecursiveAction{
    
    
    public class OrdenarMezclaJoinFork {
        
        public void ordenar(Integer[] a) {
            Integer[] auxiliar = new Integer[a.length];
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            forkJoinPool.invoke(new OrdenarMezclaTask(a, auxiliar, 0 , a.length - 1));
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        final Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println("Array: ");
        for (int i = 0; i < a.length; i++) 
            System.out.println(a[i] + ", ");
        
        OrdenarMezclaJoinFork o = new OrdenarMezclaJoinFork(a);
    }
    
    private class OrdenarMezclaTask extends RecursiveAction {
        //private static final serialVersion long = -749935388568367268L;
        private final Integer[] a;
        private final Integer[] auxiliar;
        private final int inf;
        private final int sup;

        public OrdenarMezclaTask(Integer[] a, Integer[] auxiliar, int inf, int sup) {
                this.a = a;
                this.auxiliar = auxiliar;
                this.inf = inf;
                this.sup = sup;
        }
        
        public void ordenar(Integer[] a) {

        }

        @Override
        protected void compute() {
                if (inf < sup) {
                        int medio = inf + (sup - inf) / 2;
                        OrdenarMezclaTask izda = new OrdenarMezclaTask(a, auxiliar, inf, medio);
                        OrdenarMezclaTask dcha = new OrdenarMezclaTask(a, auxiliar, medio + 1, sup);
                        invokeAll(izda, dcha);
                        mezcla(this.a, this.auxiliar, this.inf, medio, this.sup);
                } else {
                    for (int i = 0; i < auxiliar.length; i++) {
                        System.out.println("Array: " + auxiliar[i]);
                    }
                }
        }

        private void mezcla(Integer[] a, Integer[] auxiliar, int inf, int medio, int sup){
            int i = 0;
            int leftPos = 0, rightPos = 0;
            int leftSize = medio - inf + 1;
            int rightSize = sup - medio;

            while (leftPos < leftSize && rightPos < rightSize)
                auxiliar[i++] = (a[leftPos] <= a[rightPos])
                        ? a[leftPos++]
                        : a[rightPos++];
            while (leftPos < leftSize)
                auxiliar[i++] = a[leftPos++];
            while (rightPos < rightSize)
                auxiliar[i++] = a[rightPos++];
        }

    }
    
}