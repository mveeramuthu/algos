package com.mveeramuthu.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargest {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        
        int len = nums.length;
        for(int i = k; i < len; i++) {
            if(minHeap.peek() != null && nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        
        return new ArrayList<>(minHeap);
    }
    
    public static void main(String args[]) {
        List<Integer> result = findKLargestNumbers(new int[] {3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
