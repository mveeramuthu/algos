package com.mveeramuthu.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSizeSubArraySum(int[] arr, int k) throws Exception {
        if(arr == null || arr.length <= 0) {
            throw new Exception("Error: Invalid input");
        }
        
        int arrLen = arr.length;
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;
        int maxWindowSum = Integer.MIN_VALUE;
        
        for(windowEnd = windowStart; windowEnd < arrLen; windowEnd++) {
            windowSum += arr[windowEnd];
            maxWindowSum = windowSum > maxWindowSum ?  windowSum : maxWindowSum;
            
            /*
            System.out.println(arr[windowEnd] + ", [ " + windowStart + ", " 
                    + windowEnd + " ], windowSum = " + windowSum
                    + ", maxWindowSum = " + maxWindowSum
            );
            */
            
            if(windowEnd >= k-1) {
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        
        return maxWindowSum;
    }
    
    public static void main(String args[]) {
        try {
            System.out.println(findMinSizeSubArraySum(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
            System.out.println(findMinSizeSubArraySum(new int[]{2, 1, 5, 1, 3, 2}, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
