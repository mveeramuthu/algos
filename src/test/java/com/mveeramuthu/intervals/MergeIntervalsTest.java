package com.mveeramuthu.intervals;

import org.junit.Test;

public class MergeIntervalsTest { 
    @Test
    public void test1() {
        MergeIntervals.displayIntervals(MergeIntervals.merge(new int[][]{{1, 4}, {2, 3}, {6, 7}, {7, 9}}));
        // MergeIntervals.merge(new int[][]{{7, 9}, {1, 4}, {6, 7}, {2, 3}});
    }
}
