package com.mveeramuthu.dptabulation;

import java.util.Arrays;
import java.util.stream.Stream;

public class EqualSubsetSum {
    public static boolean canEqualSubsetSum(int[] num) {
        if(num == null || num.length == 0) {
            return false;
        }
        
        /*
            row = sum | 0 <= rowLen <= sum/2
            col = num | 0 <= colLen <= num.length
         */
        int colLen = num.length;
        
        int totalSum = 0;
        for(int i=0; i<colLen; i++) {
            totalSum += num[i];
        }
        // odd number total sum => equal subset sum impossible
        if(totalSum % 2 != 0) {
            return false;
        }
            
        int requiredSum = totalSum/2;
        
        boolean[][] dp = new boolean[colLen][requiredSum + 1];
        // initialize first col
        for(int i=0; i<colLen; i++) {
            dp[i][0] = true; // sum = 0 is possible with empty set 
        }
        // initialize first row
        for(int j=1; j<=requiredSum; j++) {
            /*
                * one num is 0 and the other num is the current value
                * required sum = sum of these 2 numbers = the other num
                * required sum = overall sum / 2
             */
            
            if(num[0] == j) {
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }

        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        
        // build
        for(int i=1; i<colLen; i++) {
            for(int j=1; j<=requiredSum; j++) {
                
                /*
                // include num[i]
                if(num[i] < requiredSum) {
                    dp[i][j] = dp[i - 1][requiredSum - num[i]];
                } else { // exclude num[i]
                    dp[i][j] = dp[i - 1][j];
                }
                
                 */

                // exclude num[i]
                if(dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if(requiredSum >= num[i]) { // include num[i]
                    dp[i][j] = dp[i - 1][requiredSum - num[i]];
                } 
            }
        }

        System.out.println();
        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        
        return dp[colLen - 1][requiredSum];
    }
    
    public static void main(String args[]) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canEqualSubsetSum(num));
    }
}
