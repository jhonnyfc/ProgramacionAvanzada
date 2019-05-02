/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParalelizacionMergeSort;

/**
 *
 * @author Jhonny Chicaiza
 */
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
        } else {
            return;
        }
    }
    
    private void mezcla(Integer[] a, Integer[] auxiliar, int inf, int medio, int sup) {
        /* code */
        int auxInf = inf;
        int auxMed = medio+1;
        int size   = 0;
        while (auxInf <= medio && auxMed <= sup) {
            if (a[auxInf] <= a[auxMed]){
                auxiliar[size] = a[auxInf];
                auxInf++;
            }else{
                auxiliar[size] = a[auxMed];
                auxMed++;
            }
            size++;
        }
        if (auxInf < medio){
            for(int i = auxInf; i <= medio; i++){
                auxiliar[size] = a[i];
                size++;
            }
        }
        if (auxMed < sup){
            for(int i = auxMed; i <= sup; i++){
                auxiliar[size] = a[i];
                size++;
            }
        }
        
        int aux = inf;
        for(int i = 0; i < size; i++){
            a[aux] = auxiliar[i];
            aux++;
        }
    }
}