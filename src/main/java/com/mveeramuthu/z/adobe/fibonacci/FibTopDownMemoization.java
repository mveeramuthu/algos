package com.mveeramuthu.z.adobe.fibonacci;

public class FibTopDownMemoization {
    private static Integer[] mem = new Integer[31];

    public static int findNthFib(int n) {
        if(n <= 1) {
            return n;
        }

        mem[0] = 0;
        mem[1] = 1;

        return memoize(n);
    }

    private static int memoize(int i) {
        if(mem[i] != null) {
            return mem[i];
        }

        mem[i] = memoize(i - 1) + memoize(i - 2);

        return memoize(i);
    }

    public static void main(String args[]) {
        System.out.println(findNthFib(6));
    }
}
