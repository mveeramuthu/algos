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

            }

        }

        return -1;
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0; // points to the left end of the string
        int maxLen = 0;
        // store a mapping of character and the index where that char exist in the string.
        Map<Character, Integer> indexMap = new HashMap<>();

        int right;
        for (right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            //put in the map if the number is not already there or if it is there but not part of current window.
            if (!indexMap.containsKey(rightChar) || indexMap.get(rightChar) < left) {
                indexMap.put(rightChar, right);
            } else {
                // duplicate is found in the current window, so calculate the length and create a new window by updating the
                // left pointer.
                maxLen = Math.max(maxLen, right - left);
                int prevIndex = indexMap.get(rightChar);

                if (prevIndex >= left) {
                    left = prevIndex + 1;
                    indexMap.put(rightChar, right);
                }
            }
        }
        return Math.max(maxLen, right - left);
    }
}
