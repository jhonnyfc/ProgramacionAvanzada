/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author alumno
 */
public class Practica4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryOrderedTree<Integer> tree = new BinaryOrderedTree<>();
        //List<BinaryOrderedTree.Node> lista = new LinkedList<>();       
       
        tree.add(10);
        tree.add(5);
        tree.add(1);
        tree.add(7);
        tree.add(24);
        tree.add(56);
        tree.add(32);
        tree.add(3);
        tree.add(14);
        
        System.out.println("Numero de elementos: " + tree.numberOfElements); 
        
        //lista = tree.inorden();
        
        /*for (BinaryOrderedTree.Node node : lista) {
            System.out.println(" " + node.value);
        }*/
        
        tree.getElement(10);
        tree.getElement(7);
        tree.getElement(100);
        
      
        
        tree.helpInOrden();
        
        tree.print(System.out);

       
    }
 
    
}
