package com.mveeramuthu.dpmemoization;

public class FruitKnapsack {
    public static int getMaxProfit(int[] profits, int[] weights, int capacity) {
        return getMaxProfitHelper(profits, weights, capacity, 0);
    }

    private static int getMaxProfitHelper(int[] profits, int[] weights, 
                                          int capacity, int currentIndex) {
        if(capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        
        int profit1 = 0;
        if(weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + getMaxProfitHelper(profits, weights, 
                    capacity - weights[currentIndex], currentIndex + 1);
        }
        
        int profit2 = getMaxProfitHelper(profits, weights, capacity, currentIndex + 1);
        
        return Math.max(profit1, profit2);
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
