package Práctica8.Ejercicio1;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 5;
    private FibonacciSeries problem;

    public FibonacciTask(FibonacciSeries problem) {
        this.problem = problem;
    }

    @Override
    protected Long compute() {
        String threadName = Thread.currentThread().getName();
        int n = problem.n;
        System.out.println("MultiThread: " + threadName + " calculates " + n);
        if (n < THRESHOLD) {
            return problem.solve();
        }
        FibonacciTask f1 = new FibonacciTask(new FibonacciSeries(n-1));
        f1.fork();
        FibonacciTask f2 = new FibonacciTask(new FibonacciSeries(n-2));
        long v2 = f2.compute();
        long v1 = f1.join();
        return v1 + v2;
    }
}


