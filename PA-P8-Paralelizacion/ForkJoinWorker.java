/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paralelizacion;

import java.util.concurrent.ForkJoinPool;
/**
 *
 * @author alumno
 */
public class ForkJoinWorker {
    
    public static void main(String[] args){
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Num. of processors: " + processors);
        int n = 24;
        FibonacciSeries bigIssue = new FibonacciSeries(n);
        FibonacciTask task = new FibonacciTask(bigIssue);
        ForkJoinPool pool = new ForkJoinPool(processors);
        long startTime = System.currentTimeMillis();
        pool.invoke(task);
        long result = task.result;
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Total time: " + (endTime - startTime));
    }
}
