package com.mveeramuthu.dptabulation;

import java.util.Arrays;
import java.util.stream.Stream;

public class FruitKnapsack {
    public static int getMaxProfit(int[] profits, int[] weights, int capacity) {
        
        /* 
            row = profit
            col = capacity
         */
        
        int row = profits.length; 
        int[][] dp = new int[row + 1][capacity + 1];
        
        // initialize first column
        /*
            first col = 0 => capacity = 0 => profit = 0
         */
        for(int i=0; i<row; i++) {
            dp[i][0] = 0;
        }

        // initialize first row
        /*
            first row = 0 => weight = 0
         */
        for(int j=0; j<=capacity; j++) {
            if(weights[0] <= j) {
                dp[0][j] = profits[0];
            }
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<=capacity; j++) {
                int includeWeightProfit = 0;
                int excludeWeightProfit = 0;
                
                // include weights[i]
                if(weights[i] <= capacity) {
                    includeWeightProfit = profits[i] + dp[i - 1][capacity - weights[i]];
                }
                
                // exclude weights[i]
                excludeWeightProfit = dp[i - 1][j];
                
                dp[i][j] = Math.max(includeWeightProfit, excludeWeightProfit);
            }
        }

        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);

        return dp[row-1][capacity];
    }
    
    public static void main(String args[]) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        
        int maxProfit = getMaxProfit(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        
        maxProfit = getMaxProfit(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
