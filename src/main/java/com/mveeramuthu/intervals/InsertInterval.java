package com.mveeramuthu.intervals;

import java.util.*;

public class InsertInterval {
    public static List<Interval> insertInterval(List<Interval> intervalList, Interval newInterval) {
        var mergedList = new ArrayList<Interval>();
        if(intervalList == null || intervalList.isEmpty()) {
            return mergedList;
        }
        
        // iterate over the intervals
        for(var currInterval : intervalList) {
            if(currInterval.end < newInterval.start) {
                mergedList.add(currInterval);
            } else if(currInterval.start > newInterval.end) {
                mergedList.add(newInterval);
                newInterval = currInterval;
            } else {
                newInterval.start = Math.min(currInterval.start, newInterval.start);
                newInterval.end = Math.max(currInterval.end, newInterval.end);               
            }
        }

        mergedList.add(newInterval);
        
        return  mergedList;
    }
    
    public static void main(String args[]) {
        var intervalList = Arrays.asList(
            new Interval(1, 3),
                new Interval(5, 6),
                new Interval(9, 10)
        );
        System.out.println(intervalList);
        System.out.println(insertInterval(intervalList, new Interval(6, 8)));
    }
}
