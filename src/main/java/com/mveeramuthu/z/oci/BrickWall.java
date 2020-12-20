package com.mveeramuthu.z.oci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        if (wall == null) {
            return -1;
        }

        int wallHeight = wall.size();
        int maxWidthFrequency = 0;
        var map = new HashMap<Integer, Integer>();

        for (var row : wall) {
            int totalRowWidth = 0;

            for (var brickWidth : row) {
                totalRowWidth += brickWidth;

                int widthFrequency = map.getOrDefault(totalRowWidth, 0) + 1;
                map.put(totalRowWidth, widthFrequency);

                maxWidthFrequency = Math.max(maxWidthFrequency, widthFrequency);
            }
        }

        return wallHeight - maxWidthFrequency;
    }

    public static void main(String args[]) {
        var row1 = List.of(1, 2, 2, 1);
        var row2 = List.of(3, 1, 2);
        var row3 = List.of(1, 3, 2);
        var row4 = List.of(2, 4);
        var row5 = List.of(3, 1, 2);
        var row6 = List.of(1, 3, 1, 1);

        var wall = List.of(row1, row2, row3, row4, row5, row6);

        System.out.println(leastBricks(wall));
    }
}
