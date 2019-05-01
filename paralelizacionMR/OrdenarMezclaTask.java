package Práctica8.Ejercicio2;

import java.util.concurrent.RecursiveAction;

public class OrdenarMezclaTask extends RecursiveAction {

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
            int medio = inf + (sup-inf)/2;
            OrdenarMezclaTask izda = new OrdenarMezclaTask(a, auxiliar, inf, medio);
            OrdenarMezclaTask dcha = new OrdenarMezclaTask(a, auxiliar, medio+1, sup);
            invokeAll(izda, dcha);
            mezcla(this.a, this.auxiliar, this.inf, medio, this.sup);
        }
    }

    private void mezcla(Integer[] a, Integer[] auxiliar, int inf, int medio, int sup) {
        int i_l = inf;
        int i_r = medio + 1;
        for(int k=inf; k<=sup; k++) {
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
        for(int k=inf; k<=sup; k++) {
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
}