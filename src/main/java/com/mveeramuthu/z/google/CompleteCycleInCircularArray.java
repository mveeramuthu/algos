package com.mveeramuthu.z.google;

/**
 * Created by veeramuthum on 10/29/18.
 */
public class CompleteCycleInCircularArray {

    public static boolean findCompleteCycle(int[] arr) {

        // null check
        if(arr == null || arr.length <= 0) {
            return false;
        }

        int arrLen = arr.length;
        int currIndex = 0;

        for(int i=0; i<arrLen; i++) {

            // arr = {2, 2, -1}
            // arr[0] % 3 = 2 % 3 = 2
            // 0 + 2 + 3 = 5
            // 5 % 3 = 2

            // arr = {8, 2, -1}
            // arr[0] % 3 = 8 % 3 = 2
            // 8 + 2 + 3 = 13
            // 13 % 3 = 1

            currIndex = (currIndex + arr[currIndex]) % arrLen;

            if(currIndex < 0) {
                currIndex = currIndex + arrLen;
            }

            if(currIndex == 0 && i < arrLen - 1) {
                return false;
            }
        }

        if(currIndex == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) {
        System.out.println(findCompleteCycle(new int[] {2, 2, -1}));
        System.out.println(findCompleteCycle(new int[] {2, -1, 1, 2, 2}));
    }
}
