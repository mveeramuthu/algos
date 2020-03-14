package com.mveeramuthu.z.sift;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


Problem: Given a set of n points, each with coordinates (x,y), return the k-closest points to the origin (0,0).

INPUT: (1,1), (2,3), (4,5), (10,11) and k = 3
OUTPUT: (1,1), (2,3), (4,5)


getDistance(x,y) -> distance
 */


class KclosestPairs {

    public List<Pair<Integer, Integer>> getKClosest(List<Pair<Integer, Integer>> inputList, int k) {

        List<Pair<Integer, Integer>> kClosestPairs = new ArrayList<>(k);

        // create min heap
        PriorityQueue<Integer> distanceMinHeap = new PriorityQueue<>();

        for(var pair : inputList) {
            int distance = getDistance(pair.x, pair.y);
            distanceMinHeap.put(distance);
        }

        for(int i=0; i<k; i++) {
            kClosestPairs.add(distanceMinHeap.getTop());
            distanceMinHeap.removeTop();
        }

        return kClosestPairs;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
