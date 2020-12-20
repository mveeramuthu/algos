package com.mveeramuthu.z.oci;

import com.mveeramuthu.ds.Pair;

import java.util.*;

class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        /*
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        */

        map.computeIfAbsent(key, v -> new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        var pairList = map.get(key);
        int index = search(pairList, timestamp);

        if(index == -1) {
            return "";
        } else {
            return pairList.get(index).getSecond();
        }
    }

    private int search(List<Pair<Integer, String>> pairList, int inputTimestamp) {
        if(pairList == null || pairList.size() <= 0) {
            return -1;
        }

        int valuesLen = pairList.size();
        int left = 0;
        int right = valuesLen - 1;
        int pivot = 0;

        while(left <= right) {
            pivot = left + (right - left) / 2;

            var pair = pairList.get(pivot);
            var timestamp = pair.getFirst();

             if(inputTimestamp < timestamp) {
                 left = pivot + 1;
             } else {
                 right = pivot - 1;
             }
        }

        return right;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
