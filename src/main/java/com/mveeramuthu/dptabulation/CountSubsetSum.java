package com.mveeramuthu.dptabulation;

import java.util.Arrays;
import java.util.stream.Stream;

public class CountSubsetSum {
    public static int subsetSumCount(int[] num, int sum) {
        if(num == null || num.length == 0) {
            return 0;
        }
        
        int numLen = num.length;
        int[][] dp = new int[numLen][sum + 1];
        
        // initialize first col
        for(int i=0; i<numLen; i++) {
            dp[i][0] = 1; // sum = 0 is possible with empty set 
        }
        // initialize first row
        for(int j=1; j<=sum; j++) {
            if(num[0] == j) {
                dp[0][j] = 1;
            }
        }

        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        
        
        
        // build
        for(int i=1; i<numLen; i++) {
            for(int j=1; j<=sum; j++) {
                // exclude num[i]
                dp[i][j] = dp[i - 1][j];
                
                if(j >= num[i]) { // include num[i]
                    dp[i][j] = dp[i][j] + dp[i - 1][j - num[i]];
                }
            }
        }

        System.out.println();
        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        
        return dp[numLen - 1][sum];
    }
    
    public static void main(String args[]) {
        int[] num = {1, 1, 2, 3};
        System.out.println(subsetSumCount(num, 4));
    }
}
