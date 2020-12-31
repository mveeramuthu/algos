package com.mveeramuthu.z.oci;

import java.util.Arrays;

class FirstUniqChar {
    public static int firstUniqChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }

        int strLen = str.length();
        int[] map = new int[26];

        System.out.println("map1:" + Arrays.toString(map));
        for (int i = 0; i < strLen; i++) {
            char currChar = str.charAt(i);
            map[currChar - 'a'] ++;
        }

        System.out.println("map2:" + Arrays.toString(map));

        for (int i = 0; i < strLen; i++) {
            char currChar = str.charAt(i);
            if (map[currChar - 'a'] == 1) {
                System.out.println(currChar);
                return i;
            }
        }

        System.out.println("map3:" + Arrays.toString(map));

        return -1;
    }

    public static void main(String args[]) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
