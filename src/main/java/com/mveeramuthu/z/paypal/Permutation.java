package com.mveeramuthu.z.paypal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by veeramuthum on 8/17/16.
 */
public class Permutation {

    public static List<String> getPermutations(String inStr) {

        List<String> permutations = new ArrayList<>();
        permutations.addAll(getPermutations("", inStr, new HashSet<>()));

        return permutations;
    }

    private static Set<String> getPermutations(String prefix, String remStr, Set<String> permutations) {

        int remStrLen = remStr.length();

        // If there is no more string to process, add prefix to the result set
        if(remStrLen == 1) {
            permutations.add(prefix + remStr);
        }
        else {

            // Recursively find all permutation by splitting the string at all index
            for(int i=0; i<remStrLen; i++) {
                getPermutations( (prefix + remStr.charAt(i)) ,(remStr.substring(0, i) + remStr.substring(i+1)), permutations);
            }
        }

        return permutations;
    }

    public static void main(String args[]) {

        List<String> permutations = getPermutations("abc");
        for(String permutation : permutations)
            System.out.println(permutation);
    }
}
