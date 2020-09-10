package com.mveeramuthu.graph.dfs;

/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 */

/* 
Algo:

Basically we are counting the number of 1s that are connected by doing DFS.
The DFs method just marks the visited nodes.

1. islandCount = 0
2. Linear scan the graph until we hit a 1
3. Assign this node as root node
4. islandCount++  
5. Perform DFS from this root node searching for other 1s
6. Set visited node as 0 in the graph (so that we don't visit that node again)
7. Repeat the above steps for each node with value as 1
8. Return islandCount 

 */

public class IslandsCount {
    private static int getIslandcount(int[][] graph) {
        int islandCount = 0;
        
        if(graph == null || graph.length <= 0) {
            return islandCount;
        }
        
        int rowLen = graph.length;
        int colLen = graph[0].length;

        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                
                // part of island
                if(graph[i][j] == 1) {
                    islandCount++;
                    dfs(graph, i, j);
                }
            }
        }
        
        return islandCount;
    }

    private static void dfs(int[][] graph, int row, int col) {
        // check index out of bounds
        if(row < 0 || col < 0 || row > graph.length-1 || col > graph[0].length-1) {
            return;
        }
        
        // already visited?
        if(graph[row][col] == 0) {
            return;
        }
        
        // mark as visited
        graph[row][col] = 0;

        dfs(graph, row-1, col);
        dfs(graph, row+1, col);
        dfs(graph, row, col-1);
        dfs(graph, row, col+1);
    }
    
    public static void main(String args[]) {
        int[][] grid = {{1,1,0}, {1,0,0}, {0,1,0}};
        System.out.println(getIslandcount(grid));
    }
}
