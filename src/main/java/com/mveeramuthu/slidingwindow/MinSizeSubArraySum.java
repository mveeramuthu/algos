package com.mveeramuthu.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSizeSubArraySum(int[] arr, int sum) throws Exception {
        if(arr == null || arr.length <= 0) {
            throw new Exception("Error: Invalid input");
        }
        
        int arrLen = arr.length;
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;

        int minWindowLen = Integer.MAX_VALUE;

        for(windowEnd = windowStart; windowEnd < arrLen; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= sum) {
                int windowLen = windowEnd - windowStart + 1;
                minWindowLen = Math.min(windowLen, minWindowLen);
                      
                /*
                System.out.println(arr[windowEnd] + ", [ " + windowStart + ", " 
                        + windowEnd + " ], windowSum = " + windowSum
                        + ", windowLen = " + windowLen
                        + ", minWindowLen = " + minWindowLen
                );
                
                 */

                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        
        return minWindowLen;
    }
    
    public static void main(String args[]) {
        try {
            System.out.println(findMinSizeSubArraySum(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
            System.out.println(findMinSizeSubArraySum(new int[]{2, 1, 5, 2, 3, 2}, 7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
