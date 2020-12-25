package com.mveeramuthu.z.oci;

import java.util.HashMap;

class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        int len = str1.length();
        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
            } else {
                map.put(str1.charAt(i), 1);
            }

            if (map.containsKey(str2.charAt(i))) {
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
            } else {
                map.put(str2.charAt(i), -1);
            }
        }

        for (var entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
