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
        if(str == null || str.length() <= 0) {
            return 0;
        }

        int[] map = new int[128];
        int strLen = str.length(), maxSubStrLen = 0, start = 0, end = 0;

        while(end < strLen) {
            char currChar = str.charAt(end);

            start = Math.max(map[currChar], start);

            int subStrLen = end + 1 - start;
            maxSubStrLen = Math.max(maxSubStrLen, subStrLen);

            map[currChar] = end + 1;

            end++;
        }

        return maxSubStrLen;
    }
}
