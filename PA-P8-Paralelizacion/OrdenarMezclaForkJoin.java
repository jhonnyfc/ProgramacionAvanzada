/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParalelizacionMergeSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Jhonny Chicaiza
 */
public class OrdenarMezclaForkJoin {
    public void ordena(Integer[] a) {
        int processors            = Runtime.getRuntime().availableProcessors();
        Integer[] auxiliar        = new Integer[a.length];
        ForkJoinPool forkJoinPool = new ForkJoinPool(processors);
        
        forkJoinPool.invoke(new OrdenarMezclaTask(a, auxiliar, 0, a.length - 1));
    }
    
    private class OrdenarMezclaTask extends RecursiveAction {

        private static final long serialVersionUID = -749935388568367268L;
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

        @Override
        protected void compute() {
            if (inf < sup) {
                int medio = inf + (sup - inf) / 2;
                OrdenarMezclaTask izda = new OrdenarMezclaTask(a, auxiliar, inf, medio);
                OrdenarMezclaTask dcha = new OrdenarMezclaTask(a, auxiliar, medio + 1, sup);
                invokeAll(izda, dcha);
                mezcla(this.a, this.auxiliar, this.inf, medio, this.sup);
            } else {
                return;
            }
        }

        private void mezcla(Integer[] a, Integer[] auxiliar, int inf, int medio, int sup) {
            /* code */
            int auxInf = inf;
            int auxMed = medio + 1;
            int size = 0;
            while (auxInf <= medio && auxMed <= sup) {
                if (a[auxInf] <= a[auxMed]) {
                    auxiliar[size] = a[auxInf];
                    auxInf++;
                } else {
                    auxiliar[size] = a[auxMed];
                    auxMed++;
                }
                size++;
            }
            if (auxInf < medio) {
                for (int i = auxInf; i <= medio; i++) {
                    auxiliar[size] = a[i];
                    size++;
                }
            }
            if (auxMed < sup) {
                for (int i = auxMed; i <= sup; i++) {
                    auxiliar[size] = a[i];
                    size++;
                }
            }

            int aux = inf;
            for (int i = 0; i < size; i++) {
                a[aux] = auxiliar[i];
                aux++;
            }
        }
    }

}
