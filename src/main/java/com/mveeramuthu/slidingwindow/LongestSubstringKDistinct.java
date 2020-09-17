package com.mveeramuthu.slidingwindow;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) throws Exception {
        if(str == null || str.length() <= 0) {
            throw new Exception("Error: Invalid input");
        }
        
        int arrLen = str.length();
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;

        int minWindowLen = Integer.MAX_VALUE;

        /*
        
        for(windowEnd = windowStart; windowEnd < arrLen; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= sum) {
                int windowLen = windowEnd - windowStart + 1;
                minWindowLen = Math.min(windowLen, minWindowLen);
                      
                System.out.println(arr[windowEnd] + ", [ " + windowStart + ", " 
                        + windowEnd + " ], windowSum = " + windowSum
                        + ", windowLen = " + windowLen
                        + ", minWindowLen = " + minWindowLen
                );
                

                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        */

        return minWindowLen;
    }
    
    public static void main(String args[]) {
        try {
            System.out.println(findLength("araaci", 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
