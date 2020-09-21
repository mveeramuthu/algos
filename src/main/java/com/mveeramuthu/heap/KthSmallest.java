package com.mveeramuthu.heap;

import java.util.PriorityQueue;

public class KthSmallest {
    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (n1, n2) -> n2 - n1);
        for(int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        
        int len = nums.length;
        for(int i = k; i < len; i++) {
            if(maxHeap.peek() != null && nums[i] > maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        
        return maxHeap.peek();
    }
    
    public static void main(String args[]) {
        System.out.println(findKthSmallestNumber(new int[] {3, 1, 5, 12, 2, 11}, 3));
    }
}
