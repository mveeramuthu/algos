package com.mveeramuthu.intervals;

import java.util.*;

public class MergeIntervals {
    
    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] arr1, int[] arr2) {
            if(arr1[0] < arr2[0]) {
                return -1;
            } else if(arr1[0] == arr2[0]) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        
        if(intervals == null || intervals.length <= 0) {
            return intervals;
        }

        System.out.println("Before: ");
        displayIntervals(intervals);

        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        
        System.out.println("After: ");
        displayIntervals(intervals);

        System.out.println("Result: ");
        
        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        
        for(int[] currInterval : intervals) {
            
            if(mergedIntervals.isEmpty()) {
                mergedIntervals.add(currInterval);
            } else {
                int[] lastInterval = mergedIntervals.getLast();
                
                if(lastInterval[1] < currInterval[0]) {
                    mergedIntervals.add(currInterval);
                } else {
                    
                    
                    mergedIntervals.getLast()[1] = 
                            Math.max(mergedIntervals.getLast()[1],
                                    currInterval[1]);
                    
                    /*                    
                    int end = Math.max(
                            lastInterval[1],
                            currInterval[1]
                    );
                    
                    int[] newInterval = new int[] {currInterval[0], end};
                    
                    mergedIntervals.removeLast();
                    mergedIntervals.add(newInterval);
                    */
                }
            }
            
        }
        
        return mergedIntervals.toArray(new int[0][0]);
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
    
    public static List<Interval> merge(List<Interval> intervalList) {
        var mergedList = new ArrayList<Interval>();
        if(intervalList == null || intervalList.isEmpty()) {
            return mergedList;
        }
        
        // sort the intervals by sort time
        Collections.sort(intervalList, Comparator.comparingInt(i -> i.start));
        
        // iterate over the intervals
        var intervalIterator = intervalList.iterator();
        var currInterval = intervalIterator.next();
        int start = currInterval.start;
        int end = currInterval.end;
        
        while(intervalIterator.hasNext()) {
            var nextInterval = intervalIterator.next();
            
            // intervals are overlapping
            if(nextInterval.start <= end) {
                end = Math.max(nextInterval.end, end);
            } else { // intervals don't overlap
                mergedList.add(new Interval(start, end));
                start = nextInterval.start;
                end = nextInterval.end;
            }
        }
        
        mergedList.add(new Interval(start, end));
        
        return  mergedList;
    }
    
    public static void main(String args[]) {
        var intervalList = Arrays.asList(
            new Interval(1, 3),
                new Interval(5, 6),
                new Interval(2, 8),
                new Interval(9, 10)
        );
        System.out.println(intervalList);

        System.out.println(merge(intervalList));
    }
}
