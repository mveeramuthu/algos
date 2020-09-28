package com.mveeramuthu.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalsIntersection {
    public static List<Interval> merge(List<Interval> intervalList1, List<Interval> intervalList2) {
        var mergedList = new ArrayList<Interval>();
        if(intervalList1 == null || intervalList1.isEmpty() 
            || intervalList2 == null || intervalList2.isEmpty()) {
            return mergedList;
        }
        
        // iterate over the intervals
        var list1Iterator = intervalList1.listIterator();
        var list2Iterator = intervalList2.listIterator();
        
        while(list1Iterator.hasNext() && list2Iterator.hasNext()) {
            var list1Interval = list1Iterator.next();
            var list2Interval = list2Iterator.next();
            
            if((list1Interval.start >= list2Interval.start && list1Interval.start <= list1Interval.end) ||
                    (list2Interval.start >= list1Interval.start && list2Interval.start <= list2Interval.end)) {
                int start = Math.min(list1Interval.start, list2Interval.start);
                int end = Math.max(list1Interval.end, list2Interval.end);
                var newInterval = new Interval(start, end);
                mergedList.add(newInterval);
            }
        }
        
        return  mergedList;
    }
    
    public static void main(String args[]) {
        var list1Interval = Arrays.asList(
            new Interval(1, 3),
                new Interval(5, 6),
                new Interval(9, 10)
        );
        var list2Interval = Arrays.asList(
                new Interval(2, 4),
                new Interval(6, 8)
        );
        
        System.out.println(list1Interval);
        System.out.println(list2Interval);

        System.out.println(merge(list1Interval, list2Interval));
    }
}
