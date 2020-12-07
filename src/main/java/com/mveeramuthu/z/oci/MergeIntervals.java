package com.mveeramuthu.z.oci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 0) {
            return intervals;
        }

        int len = intervals.length;
        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        // sort intervals
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for(int[] interval : intervals) {
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }

        return mergedIntervals.toArray(new int[0][]);
    }
}
