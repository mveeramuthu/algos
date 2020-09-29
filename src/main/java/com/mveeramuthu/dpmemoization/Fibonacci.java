package com.mveeramuthu.dpmemoization;

public class Fibonacci {
    public static int fibonacci(int n) { 
        int[] memory = new int[n + 1];
        return fibonacciHelper(memory, n);
    }
    
    private static int fibonacciHelper(int[] memory, int n) {
        if(n < 2) {
            return n;
        }
        
        if(memory[n] != 0) {
            return memory[n];
        }
        
        memory[n] = fibonacciHelper(memory, n - 1) + fibonacciHelper(memory, n - 2);
        
        return memory[n];
    }
    
    public static void main(String args[]) {
        System.out.println(fibonacci(10));
    }
}
