package com.mveeramuthu.intervals;

import java.util.*;

public class MergeIntervals {

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public static int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
    
    public static void displayIntervals(int[][] intervals) {
        if(intervals == null || intervals.length <= 0) {
            return;
        }
        
        int row = intervals.length;
        int col = intervals[0].length;
        
       for(int i=0; i<row; i++) {
           System.out.print("{");
           for(int j=0; j<col; j++) {
               System.out.print(intervals[i][j] + ", ");
           }
           System.out.println("}, ");
       }
    }
}
