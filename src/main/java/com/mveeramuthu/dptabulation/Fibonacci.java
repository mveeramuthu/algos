package com.mveeramuthu.dptabulation;

public class Fibonacci {
    public static int fibonacci(int n) { 
        if(n == 0) {
            return 0;
        }
        
        int[] memory = new int[n + 1];
        memory[0] = 0;
        memory[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        
        return memory[n];
    }
    
    public static void main(String args[]) {
        System.out.println(fibonacci(10));
    }
}
