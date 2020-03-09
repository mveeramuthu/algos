package com.mveeramuthu.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without
 * repeating characters.
 *
 */

public class LongestNonRepeatingSubstring {

    public int getLen(String str) {

        int left = 0;
        int right = 0;
        int maxLen = 0;

        // map of character and it's position in the input string
        Map<Character, Integer> posMap = new HashMap<>();

        for(right=0; right<str.length(); right++) {

            char rightChar = str.charAt(right);
            if(!posMap.containsKey(rightChar) || posMap.get(rightChar)<left) {
                posMap.put(rightChar, right);
            } else {
                maxLen = Math.max(maxLen, right-left);
                int prevIndex = posMap.get(rightChar);

                if (prevIndex >= left) {
                    
                    left = prevIndex + 1;
                    posMap.put(rightChar, right);
                    
                }
            }

        }

        return Math.max(maxLen, right - left);
    }
}
