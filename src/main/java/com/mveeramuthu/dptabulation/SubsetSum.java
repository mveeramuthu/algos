package com.mveeramuthu.dptabulation;

import java.util.Arrays;
import java.util.stream.Stream;

public class SubsetSum {
    public static boolean canSubsetSum(int[] num, int sum) {
        if(num == null || num.length == 0) {
            return false;
        }
        
        /*
            row = sum | 0 <= rowLen <= sum
            col = num | 0 <= colLen <= num.length
         */
        int numLen = num.length;
        boolean[][] dp = new boolean[numLen][sum + 1];
        
        // initialize first col
        for(int i=0; i<numLen; i++) {
            dp[i][0] = true; // sum = 0 is possible with empty set 
        }
        
        // initialize first row
        for(int j=1; j<=sum; j++) {
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
        for(int i=1; i<numLen; i++) {
            for(int j=1; j<=sum; j++) {
                // exclude num[i]
                if(dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if(sum >= num[i]) { // include num[i]
                    dp[i][j] = dp[i - 1][sum - num[i]];
                } 
            }
        }

        System.out.println();
        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        
        return dp[numLen - 1][sum];
    }
    
    public static void main(String args[]) {
        int[] num = {1, 2, 3, 7};
        System.out.println(canSubsetSum(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(canSubsetSum(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(canSubsetSum(num, 6));
    }
}
