/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSetExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author alumno
 */
public class SetExample {

    public static void main(String[] args) {

        Set setA = new LinkedHashSet();

        setA.add("element 1");
        setA.add("element 2");
        setA.add("element 3");

        System.out.println(setA.contains("element 1"));

        /* Diferentes formas de iterar un set*/
        for (Iterator iterator = setA.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println(next);
        }

        for (Object o : setA) {
            System.out.println(o);
        }

        Iterator iterator = setA.iterator();
        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            System.out.println(element);
        }

        for (Object object : setA) {
            String element = (String) object;
        }

        /* Add all elements from antoher collection */
        List arr = new ArrayList();
        arr.add("Ruben");
        arr.add("Piruleta");
        arr.add("Gominola");

        setA.addAll(arr);
        System.out.println("[+] 1- Contenido set: ");
        for (Iterator iterator1 = setA.iterator(); iterator1.hasNext();) {
            Object next = iterator1.next();
            System.out.println("\t" + next);
        }

        /* Remove All Elements From Another Collection */
        setA.removeAll(arr);
        System.out.println("[+] 2- Contenido set: ");
        for (Iterator iterator1 = setA.iterator(); iterator1.hasNext();) {
            Object next = iterator1.next();
            System.out.println("\t" + next);
        }

        /* Retain All Elements Present in Another Collection */
        setA.add("Piruleta");
        setA.retainAll(arr);
        System.out.println("[+] 3- Contenido set: ");
        for (Iterator iterator1 = setA.iterator(); iterator1.hasNext();) {
            Object next = iterator1.next();
            System.out.println("\t" + next);
        }

        /* Size of the set */
        int size = setA.size();
        System.out.println(size);

        /* Comprueba si esta vacio */
        boolean isEmpty = setA.isEmpty();
        System.out.println(isEmpty);

        /* Generics */
        Set<MyObj> set = new HashSet<>();

        for (MyObj anObject : set) {
            //do someting to anObject...
        }

        /* Sorting ArraYList */
        List arr2 = new ArrayList();

        List<MyObj> arrObj = new ArrayList<>();
        arrObj.add(new MyObj("ruben", "humano", 5, 5));
        arrObj.add(new MyObj("Piruleta", "humano", 2, 10));
        arrObj.add(new MyObj("Gominola", "humano", 7, 1));
        
        MyObj obj = new MyObj("aitor", "bobo", 90, 4324);
        System.out.println(obj);

        /* Sort an ArrayList using comparator*/
        Collections.sort(arrObj, (MyObj o1, MyObj o2) -> (o1.getSize() - o2.getSize()));

        /* Sort an ArrayList using lambda expression */
        Collections.sort(arrObj, new Comparator<MyObj>() {
            @Override
            public int compare(MyObj o1, MyObj o2) {
                return (o1.getSize() - o2.getSize());
            }
        });

        for (MyObj m : arrObj) {
            System.out.println(m.getSize());
        }

        /* Remove elements from sets */
        setA.remove("element 1");

        /* Remove all elements form set */
        setA.clear();

    }

}
