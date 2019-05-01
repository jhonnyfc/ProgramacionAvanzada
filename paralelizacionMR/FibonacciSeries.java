package Práctica8.Ejercicio1;

public class FibonacciSeries {
    public int n;
    public FibonacciSeries(int n) {
        this.n = n;
    }

    public long solve() {
        return fibonacci(n);
    }

    private long fibonacci(int n) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread: " + threadName + " calculates " + n);
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String args[]) {
        FibonacciSeries f = new FibonacciSeries(5);
        System.out.println(f.solve());
    }
}


