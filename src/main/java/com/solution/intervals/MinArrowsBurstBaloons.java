package com.solution.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinArrowsBurstBaloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;

        Arrays.sort(points, (a, b) -> a[1]-b[1]);

        List<int[]> result = new ArrayList<>();
        int[] startPoint = points[0];
        result.add(startPoint);
        for (int i =1;i<points.length;i++){
            if (points[i][0] <= startPoint[1])
                continue;   // This line is different from merge intervals, we are keeping the minimum value as it is here whereas the maximum value out oof the two intervals was selected in merge intervals.
            else{
                startPoint = points[i];
                result.add(startPoint);
            }
        }
        return result.size();
    }
}


