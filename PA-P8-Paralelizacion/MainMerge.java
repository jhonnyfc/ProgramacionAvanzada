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
public class MainMerge {

    public static int N = 20;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] vector = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            vector[i] = (int) (Math.random()*100000) % 100000;
        }
        
        for (Integer o1 : vector){
            System.out.print(" " + o1);
        }
        System.out.println("");
        
        OrdenarMezclaForkJoin mergeFork = new  OrdenarMezclaForkJoin();
        mergeFork.ordena(vector);
        
        //OrdenarMezcla ordenaBasic = new  OrdenarMezcla();
        //ordenaBasic.ordena(vector);
        
        for (Integer o1 : vector){
            System.out.print(" " + o1);
        }
        System.out.println("");
    }
}
