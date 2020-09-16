package com.mveeramuthu.slidingwindow;

public class MaxSubArraySum {
    public static int findMaxSubArraySum(int[] arr, int k) throws Exception {
        if(arr == null || arr.length <= 0) {
            throw new Exception("Error: Invalid input");
        }
        
        int arrLen = arr.length;
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;
        int maxWindowSum = Integer.MIN_VALUE;
        
        for(windowEnd = windowStart; windowEnd < arrLen; windowEnd++) {

            System.out.println(arr[windowEnd] + " [ " + windowStart + ", " + windowEnd + " ]");
            
            
            
            if(windowEnd == k-1) {
                windowStart++;
            }
        }
        
        return maxWindowSum;
    }
    
    public static void main(String args[]) {
        try {
            System.out.println(findMaxSubArraySum(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
