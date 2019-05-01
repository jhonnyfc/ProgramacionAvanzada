package Práctica8.Ejercicio1;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinWorker {

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Num of processors: " + processors);
        int n = 6;
        FibonacciSeries bigIssue = new FibonacciSeries(n);
        FibonacciTask task = new FibonacciTask(bigIssue);
        ForkJoinPool pool = new ForkJoinPool(processors);
        long startTime = System.currentTimeMillis();
        long resultado = pool.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + resultado);
        System.out.println("Total time: " +  (endTime - startTime));
    }
}

