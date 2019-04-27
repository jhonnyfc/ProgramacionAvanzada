/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paralelizacion;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author alumno
 */
public class FibonacciTask extends RecursiveTask<Long>{
    
    private static final int THRESHOLD = 5;
    private FibonacciSeries problem;
    public long result;
    
    public FibonacciTask(FibonacciSeries problema){
        this.problem = problema;
    }
    
    @Override
    public Long compute(){
        if(problem.n < THRESHOLD){
            result = problem.solve();
            return result;
        }
        FibonacciTask f1 = new FibonacciTask(new FibonacciSeries(problem.n - 1));
        f1.fork();
        FibonacciTask f2 = new FibonacciTask(new FibonacciSeries(problem.n - 2));
        result = f2.compute() + f1.join();
        return result;
    }
}
