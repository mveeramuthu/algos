package com.mveeramuthu.bfsother;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to c
            int n = subsets.size();

            System.out.println("n = " + n);
            
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current elemen
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> result = Subset.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);
        
        result = Subset.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
