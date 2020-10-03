package com.mveeramuthu.dptabulation;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinSubsetSumDiff {
    public static int minSubsetSumDiff(int[] num) {
        if(num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int numLen = num.length;
        int totalSum = 0;
        for(int i=0; i<numLen; i++) {
            totalSum += num[i];
        }
        int requiredSum = totalSum / 2;
        System.out.println("requiredSum = " + requiredSum);
        
        boolean[][] dp = new boolean[numLen][requiredSum+1];
        
        // initialize col
        for(int i=0; i<numLen; i++) {
            dp[i][0] = true;
        }
        
        // initialize row
        for(int j=1; j<=requiredSum; j++) {
            if(num[0] == j) {
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }
        
        for(int i=1; i<numLen; i++) {
            for(int j=1; j<=requiredSum; j++) {
                if(dp[i-1][j]) {
                    dp[i][j] = true;
                } else if(j >= num[i]) { // dp[i-1][j] == false && curr sum > remaining number
                    dp[i][j] = dp[i-1][j - num[i]];
                }
            }
        }

        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        
        // get largest required sum of the 'true' cell in last row
        int trueRequiredSum = 0;
        for(int j=requiredSum; j>=0; j--) {
            if(dp[numLen-1][j]) {
                trueRequiredSum = j;
            }
        }

        System.out.println("trueRequiredSum = " + trueRequiredSum);
        
        int minSubsetSumDiff = requiredSum - trueRequiredSum;
        return  minSubsetSumDiff;
    } 
    
    public static void main(String args[]) {
        int[] num = {1, 2, 3, 9};
        System.out.println(minSubsetSumDiff(num));
        
        /*
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(minSubsetSumDiff(num));
        
        num = new int[]{1, 3, 100, 4};
        System.out.println(minSubsetSumDiff(num));
        
         */
    }
}
