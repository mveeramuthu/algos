package com.mveeramuthu.dptabulation;

public class MinSubsetSumDiff {
    public static int minSubsetSumDiff(int[] num) {
        
        return -1;
    } 
    
    public static void main(String args[]) {
        int[] num = {1, 2, 3, 9};
        System.out.println(minSubsetSumDiff(num));
        
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(minSubsetSumDiff(num));
        
        num = new int[]{1, 3, 100, 4};
        System.out.println(minSubsetSumDiff(num));
    }
}
