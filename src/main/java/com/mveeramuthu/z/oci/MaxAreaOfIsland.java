package com.mveeramuthu.z.oci;

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }

        int maxArea = 0;
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        boolean[][] visited = new boolean[maxRow + 1][maxCol + 1];

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                maxArea = Math.max(maxArea, maxAreaOfIsland(grid, visited, i, j));
            }
        }

        return maxArea;
    }

    private int maxAreaOfIsland(int[][] grid, boolean[][] visited, int row, int col) {
        // check bounds and check if visited
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + maxAreaOfIsland(grid, visited, row-1, col)
                + maxAreaOfIsland(grid, visited, row+1, col)
                + maxAreaOfIsland(grid, visited, row, col-1)
                + maxAreaOfIsland(grid, visited, row, col+1);
    }
}
