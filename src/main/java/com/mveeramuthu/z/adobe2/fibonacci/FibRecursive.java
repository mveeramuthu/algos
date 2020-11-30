package com.mveeramuthu.z.adobe2.fibonacci;

public class FibRecursive {
    public static int findNthFib(int n) {
        if(n <= 1) {
            return n;
        }
        return findNthFib(n - 1) + findNthFib(n - 2);
    }

    public static void main(String args[]) {
        System.out.println(findNthFib(6));
    }
}
