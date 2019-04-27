/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paralelizacion;

/**
 *
 * @author alumno
 */
public class FibonacciSeries {
    
    public int n;
    
    public FibonacciSeries (int n) {
        this.n = n;
    }
    
    public long solve(){
        return fibonacci(n);
    }
    
    private long fibonacci(int n){
        System.out.println("Thread: " + Thread.currentThread().getName() + " calculates " + n);
        if (n <= 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
    
}
