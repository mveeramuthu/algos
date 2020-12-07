package com.mveeramuthu.z.adobe.fibonacci;

public class FibBottomUpMemoization {
    public static int findNthFib(int n) {
        if(n <= 1) {
            return n;
        }

        int[] mem = new int[n + 1];
        mem[1] = 1;

        for(int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        return mem[n];
    }

    public static void main(String args[]) {
        System.out.println(findNthFib(6));
    }
}
