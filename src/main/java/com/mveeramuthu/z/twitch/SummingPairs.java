package com.mveeramuthu.z.twitch;


    import java.io.*;
import java.util.*;

//import javafx.util.Pair;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 arr = [3, 6, 3, 6, 2, 7, 0, 9] t=9
 (3, 6) (6, 3)





 */

class Pair<K, V> {

    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }



}


public class SummingPairs {

        public static List<Pair<Integer, Integer>> getPairs(int[] arr, int target) {

            if(arr == null || arr.length <=0) {
                return null;
            }

            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int arrLen = arr.length;

            for (int i=0; i<arrLen; i++) { // arr[i] = 7

                int diff = target-arr[i]; // 9 -7 = 2

                if(!map.containsKey(arr[i])) {
                    map.put(arr[i], diff); // (2, 7), (7, 2)
                }
            }

            map.entrySet().forEach(entry -> {
                    if(map.containsKey(entry.getValue())) {

                        // TODO: check already present
                        pairs.add(new Pair<Integer, Integer>(entry.getKey(), entry.getValue()));
                    }
                }
            );

            return pairs;
        }



        public static void main(String[] args) {
            // (2, 7), (2,7)
            List<Pair<Integer, Integer>> pairs = getPairs(new int[]{2, 7, 2, 8, 0, 9}, 9);

            pairs.forEach(pair -> {
                System.out.println("(" + pair.key + "," + pair.value + "), ");
            });
        }
    }

