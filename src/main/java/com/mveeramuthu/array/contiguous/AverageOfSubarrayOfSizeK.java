package com.mveeramuthu.array.contiguous;

import java.util.Arrays;
import java.util.List;

public class AverageOfSubarrayOfSizeK {
    
    /*
    
    1. sum of first k elements = x
    2. sum of k elements after sliding 1 = x - arr[0] + arr[k+1]
    
     */
    public static double[] findAverages(int[] arr, int k) throws Exception {
        if(arr == null || arr.length <= 0) {
            throw new Exception("Error: Invalid input"); 
        }
        
        int arrLen = arr.length;
        double[] result = new double[arrLen - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        
        for(int i = windowStart; i < arrLen; i++) {
            windowSum = windowSum + arr[i];
            if(i >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum = windowSum - arr[windowStart];
                
                // slide the window
                windowStart ++;
            }
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        try {
            Arrays.stream(
                findAverages(new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}, 5)
            ).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
