package com.mveeramuthu.z.adobe2;

public class ReverseInteger {
    public static int reverse(int num) {
        int reversedInt = 0;

        while (num != 0) {
            int pop = num % 10;
            num = num / 10;
            reversedInt = reversedInt * 10 + pop;
        }

        return reversedInt;
    }

    public static void main(String args[]) {
        System.out.println(reverse(0501));
    }
}
