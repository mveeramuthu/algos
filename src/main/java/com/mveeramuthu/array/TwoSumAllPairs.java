package com.mveeramuthu.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSumAllPairs {

    public static List<Integer> getAllUniquePairs(int[] input, int sum) {
        final List<Integer> allDifferentPairs = new ArrayList<>();
        // Aux. hash map
        final Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0, input.length).forEach(i -> {
                    if (pairs.containsKey(input[i])) {
                        if (pairs.get(input[i]) != null) {
                            // Add pair to returned list
                            allDifferentPairs.add(input[i]);
                        }
                        // Mark pair as added to prevent duplicates
                        pairs.put(sum - input[i], null);
                    } else if (!pairs.containsValue(input[i])) {
                        // Add pair to aux. hash map
                        pairs.put(sum - input[i], input[i]);
                    }
                }
        );
        return allDifferentPairs;
    }
    
}
