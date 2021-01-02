package com.mveeramuthu.z.oci;

class PaintHouses {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length <= 0) {
            return 0;
        }

        int rowLen = costs.length;

        int[] prevRow = costs[rowLen - 1]; // last row

        // start from last but 1 row
        for (int rowNum = rowLen - 2; rowNum >= 0; rowNum--) {
            var currRow = costs[rowNum];

            // red
            currRow[0] = Math.min(prevRow[1], prevRow[2]);

            // green
            currRow[1] = Math.min(prevRow[0], prevRow[2]);

            // blue
            currRow[2] = Math.min(prevRow[0], prevRow[1]);

            prevRow = currRow;
        }

        // return min of 1st row
        return Math.min(prevRow[0], Math.min(prevRow[1], prevRow[2]));
    }
}
