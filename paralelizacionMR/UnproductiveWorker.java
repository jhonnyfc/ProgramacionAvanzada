package Práctica8.Ejercicio1;

public class UnproductiveWorker {

    public static void main(String [] args) throws Exception {
        int n = 6;
        FibonacciSeries bigIssue = new FibonacciSeries(n);
        long startTime = System.currentTimeMillis();
        long resultado = bigIssue.solve();
        long endTime = System.currentTimeMillis();
        System.out.println("Calculating Fib numbers: " + n);
        System.out.println("Result: " + resultado);
        System.out.println("Total time: " + (endTime - startTime));
    }
}

