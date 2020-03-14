package com.mveeramuthu.z.uber;

import java.util.ArrayList;
import java.util.List;

// Say we have a function, void makeHttpRequest()
// Demonstrate a rate limiter that controls the rate at which the function gets called
// The required rate limit is 3 requests per second

// 1.5s - T - original ts & counter = 1
// 1.7s - T - ts2 & counter = 2
// 1.8s - T - ts3 & counter = 3
// 1.9s - F - counter = 4 // F
// 2.4s - F - counter = 5 // F
// 2.5s - T - original ts & counter = 1 
// 2.6s - F - counter = 2
// 2.7s - T
// 2.8s - T


// System.currentTimeMillis()


public class Solution {
    private static int MAX_COUNT = 3;
    private static List<Long> successTimestamps = new ArrayList<>();

    private static void makeHttpRequest() {
        System.out.println("Hello");
    }
    
    public static boolean delimiter() {
        long currTimestamp = System.currentTimeMillis();
        int len = Solution.successTimestamps.size();
        
        if(len <= 0) {
            Solution.successTimestamps.add(currTimestamp);
            makeHttpRequest();
            return true;            
        } else if(currTimestamp - Solution.successTimestamps.get(0) < 1000) {
            if(Solution.successTimestamps.size() < MAX_COUNT) {
                Solution.successTimestamps.add(currTimestamp);
                makeHttpRequest();
                return true;
            } else {
                return false;
            }
        }
        Solution.successTimestamps.remove(0);
        Solution.successTimestamps.add(currTimestamp);
        makeHttpRequest();
        return true;
    }
    
    public static void main(String args[] ) throws Exception {
        // send multiple reqs
        for(int i=0; i<10; i++) {
            delimiter();
            Thread.sleep(100); //100 ms
        }
    }
}