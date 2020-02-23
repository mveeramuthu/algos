package com.mveeramuthu.graph;

import java.util.*;

/**
 * Knight's Tour On A Chess Board
 *
 * Problem Statement:
 * You are given a rows * cols chessboard and a knight that moves like in normal chess. 
 * Currently knight is at starting position denoted by start_row th row and start_col th col, 
 * and want to reach at ending position denoted by end_row th row and end_col th col.
 * The goal is to calculate the minimum number of moves that the knight needs to take to get from starting position to ending position.
 * start_row, start_col, end_row and end_col are 0-indexed. 
 *
 * Input Format:
 * There are six arguments. First is an integer denoting rows, second is an integer denoting cols, 
 * third is an integer denoting start_row, fourth is an integer denoting start_col, fifth is an integer 
 * denoting end_row and sixth is an integer denoting end_col.
 *
 * Output Format:
 * Return an integer.
 * If it is possible to reach from starting position to ending position then return minimum number of moves that the knight 
 * needs to take to get from starting position to ending position.
 * If it is not possible to reach from starting position to ending position then return -1.
 *
 * Constraints:
 * 1 <= rows * cols <= 10^5
 * 0 <= start_row, end_row < rows
 * 0 <= start_col, end_col < cols
 *
 * Sample Test Case:
 * Sample Input:
 * rows = 5
 * cols = 5
 * start_row = 0
 * start_col = 0
 * end_row = 4
 * end_col = 1
 *
 * Sample Output:
 * 3
 *
 * Explanation:
 * 3 moves to reach from (0, 0) to (4, 1):
 * (0, 0) -> (1, 2) -> (3, 3) -> (4, 1). 
 *
 */


public class KnightTour { 
    /*
     Approach: Graph BFS
     T: O(rows * cols)
     S: O(rows * cols)
    */
    public static int findMinMoves(int rows, int cols, 
                                   int startRow, int startCol, 
                                   int endRow, int endCol) {
        // if starting and ending positions are same
        if (startRow == endRow && startCol == endCol) {
            return 0;
        }
        
        // cell visited status and distance to target node
        int[][] distance  = new int[rows][cols];
        
        // starting position can be reached from starting position in 0 moves
        distance[startRow][startCol] = 0; 

        // BFS queue
        Queue<Cell> queue = new LinkedList<>();

        // knight's possible moves
        List<Cell> directions = new ArrayList<>(
                Arrays.asList(
                        new Cell(1, 2),
                        new Cell(2, 1),
                        new Cell(-1, 2),
                        new Cell(-2, 1),
                        new Cell(1, -2),
                        new Cell(2, -1),
                        new Cell(-1, -2),
                        new Cell(-2, -1)
                )
        );

        // initial state of the cells in the chessboard
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                distance[i][j] = -1;
            }
        }
        
        // loop until queue is empty
        while(!queue.isEmpty()) {
            Cell currCell = queue.poll();
            
            // if current cell is equal to target cell, return its distance
            if(currCell.x == endRow && currCell.y == endCol) {
                return distance[endRow][endCol];
            }

            for(Cell direction: directions) {
                int x = currCell.x + direction.x;
                int y = currCell.y + direction.y;
                
                // boundry conditions
                if(x < startRow || x >= endRow 
                        || y < startCol || y >= endCol
                        || distance[x][y] <= distance[currCell.x][currCell.y]+1) {
                    continue;
                }

                // if reachable cell is not yet visited and is inside board, push that state into queue
                queue.offer(new Cell(x, y));
                // increment distance 
                distance[x][y] = distance[currCell.x][currCell.y] + 1;
            }
        }
        
        // If ending position can not be reached from starting position
        return -1;
    }
}

class Cell {
    public int x;
    public int y;
    
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}