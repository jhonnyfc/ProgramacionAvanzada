/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.io.PrintStream;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author alumno
 * @param <E>
 */
public class BinaryOrderedTree<E extends Comparable> {

    
    /* Clase que contiene el hijo izquierdo y derecho del nodo ,como el valor */
    public class Node<E extends Comparable> {
        E value; 
        Node<E> left, right;   

        public Node(E value) {
            this.value = value;
            left = right = null;
        }
    }
    
    /* Implementacion Arbol Binario */
    Node<E> root;           /* Raiz del arbol binario */
    int numberOfElements;   /* Numero de elementos del arbol binario */

    /* Constructor */
    public BinaryOrderedTree() {
        this.root = null;
        this.numberOfElements = 0;
    }
    
    /*
    * Inserta el nodo, y si ya existia devuelve false
    */
    public boolean add(E element){

        /* Nodo a insertar */
        Node nuevo = new Node(element);
        
        /* El arbol binario se encuentra vacio */
        if(root == null){
            root = nuevo;
            ++numberOfElements;   
            return true;
        }else{
            Node reco = root;            
            
            while(reco != null){
                if ((reco.value).compareTo(element) > 0)
                    if (reco.left == null){
                       reco.left = nuevo;
                       ++numberOfElements;
                       return true;
                    }else
                        reco = reco.left;
                else if((reco.value).compareTo(element) < 0)
                        if (reco.right == null){
                           reco.right = nuevo;
                           ++numberOfElements;
                           return true;
                        }else
                            reco = reco.right;
                else
                    return false;
            }
        }
        return false;
    }
    
    /*
    * Devuelve un List con los elementos del arbol en inorden
    */
    /*
    public List<Node> inorden(){
        
        Node temp = root;
        List<Node> lista = new Stack<>();
        
        if(temp == null)
            return lista;
    
        while (temp != null || lista.size() > 0){
            
            while( temp != null ){
                lista.add(temp);
                temp = temp.left;
            }
            temp = lista.get(lista.size());
            
            temp = temp.right;
        }
        return lista;
    }*/
    
    /*
    * Imprime en el PrintStream (System.out es un PrintStream) 
    * la estructura del árbol (utiliza el método toString de E)
    */
    public void print(){}
    
    public void print(PrintStream out){
        if (root!=null)
            printRec(out,root,"");
    }
    
    private void printRec(PrintStream out,Node root,String tabs){
        out.println(tabs +"|"+root.value);
        if (root.left!=null)
            printRec(out,root.left,tabs+"          ");
        if (root.right!=null)
            printRec(out,root.right,tabs+"         ");
    }
    
    public boolean getElement(int value){
        
        Node temp = root;
        while(temp != null){
            if( (temp.value).compareTo(value) == 0){
                System.out.println("El elemento " + value + "  se encuentra en el arbol");
                return true;
            }
            else if((temp.value).compareTo(value) > 0)
                temp = temp.left;
            else if((temp.value).compareTo(value) < 0)
                temp = temp.right;
        }
        System.out.println("El elemento " + value + " no esta en el arbol");
        return false;
    }
    
    public void helpInOrden(){
        Node temp = root;
        inOrden(temp);
    }
    
    public void inOrden(Node root){
        if(root == null)
            return;
        if(root.left != null)
            inOrden(root.left);
        System.out.println("" + root.value);
        if(root.right != null)
            inOrden(root.right);
    }

         
         
         
     
}

  