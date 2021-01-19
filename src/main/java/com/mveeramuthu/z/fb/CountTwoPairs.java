package com.mveeramuthu.z.fb;

import java.io.*;
import java.util.*;

class CountTwoPairs {

    /*
    {1, 2, 3, 4, 3}, 6

     i = 0, arr[0] = 1, map {1, 0}
     i = 1, arr[1] = 2, map {2, 0}
     i = 2, arr[2] = 3, map {3, 1}
     i = 3, arr[3] = 4, map {4, 0}
     i = 4, arr[4] = 3, ..

     */
    int numberOfWays(int[] arr, int k) {
        System.out.println(Arrays.toString(arr) + ", " + k);

        if (arr == null || arr.length <= 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int arrLen = arr.length;

        for (int i = 0; i < arrLen; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map);

        int count = 0;

        for (int i = 0; i < arrLen; i++) {
            int rem = k - arr[i];
            count += map.getOrDefault(rem, 0);

            if (rem == arr[i]) {
                count--;
            }

            System.out.println("count = " + count);
        }

        return count/2;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new CountTwoPairs().run();
    }
}

/*

{1=1, 3=3, 5=1}
Count of pairs is 4

 */
