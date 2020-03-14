package com.mveeramuthu.z.intuit;

/*
Given a 2D array(m x n). The task is to check if there is any path 
from top left to given cell (x, y). 
In the matrix, 0 is considered as blockage (can’t go through this cell) 
and 1 is considered path cell (can go through it). 
Can move horizontally & vertically.

Input : arr[][] = {
  { 1, 1, 0, 0, 1},
  { 0, 1, 0, 0, 0},
  { 1, 1, 0, 0, 1},
  { 0, 1, 1, 1, 1},
  { 1, 1, 1, 0, 1}
}

If the pass from (0, 0) to (4, 4) exists?
*/

import java.util.*;

class Cell {
    int x;
    int y;
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static Cell sourceCell = new Cell(0, 0);

    public boolean doesPathExist(int[][] matrix, Cell targetCell) {
        Queue<Cell> bfsQueue = new LinkedList<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        List<Cell> directions = new ArrayList<>(
                Arrays.asList(
                        new Cell(1, 0),
                        new Cell(-1, 0),
                        new Cell(0, 1),
                        new Cell(0, -1)
                )
        );

        // assumption: first cell is valid always
        bfsQueue.add(sourceCell);

        while(!bfsQueue.isEmpty()) {
            Cell currCell = bfsQueue.poll();
            
            if(currCell.x == targetCell.x && currCell.y == targetCell.y) {
                // path found
                return true;
            }
            
            for(Cell direction : directions) {
                int x = currCell.x + direction.x; // 0 + 1 = 1
                int y = currCell.y + direction.y; // 0 + 0 = 0

                if(x < 0 || x >= rowLen || y < 0 || y >= colLen || matrix[x][y] == 0) {
                    continue;
                }

                bfsQueue.add(new Cell(x, y));
                matrix[x][y] = 0;
            }
        }

        return false;
    }

    public static void main(String args[]) {

    }
}