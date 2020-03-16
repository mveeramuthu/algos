package com.mveeramuthu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> getThreeSum(int[] nums, int sum) {
        List<List<Integer>> triplets = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return triplets;
        }

        Arrays.sort(nums);
        
        int numsLen = nums.length;
        
        for(int currIndex=0; currIndex<numsLen-2; currIndex++) {
            if(currIndex == 0 || nums[currIndex] > nums[currIndex-1]) {

                int negate = sum - nums[currIndex];
                int startIndex = currIndex + 1;
                int endIndex = numsLen - 1;

                while (startIndex < endIndex) {
                    int pairSum = nums[startIndex] + nums[endIndex];

                    if (pairSum == negate) {
                        List<Integer> triplet = new ArrayList<>(3);
                        triplet.add(nums[startIndex]);
                        triplet.add(nums[endIndex]);
                        triplet.add(nums[currIndex]);
                        triplets.add(triplet);

                        startIndex++;
                        endIndex--;
                        
                        /*
                        while(startIndex < endIndex && nums[startIndex] == nums[startIndex+1]) { 
                            startIndex++;    
                        }
                        
                        while(startIndex < endIndex && nums[endIndex] == nums[endIndex-1]) { 
                            endIndex--;
                        }
                        
                         */
                        
                    } else if (pairSum < negate) {
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                }
            }
        }
        
        return triplets;
    }
}
