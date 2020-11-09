package com.mveeramuthu.graph.dfs;

public class IslandMaxArea {
    public static int getMaxArea(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        if(grid == null || grid.length == 0) {
            return maxArea;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row+1][col+1];

        for (int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length
            || visited[row][col]
            || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;

        return dfs(grid, visited, row-1, col) +
                dfs(grid, visited, row, col-1) +
                dfs(grid, visited, row, col+1) +
                dfs(grid, visited, row+1, col) + 1;
    }

    public static void main(String args[]) {
        System.out.println(getMaxArea(new int[][]{
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }
}
