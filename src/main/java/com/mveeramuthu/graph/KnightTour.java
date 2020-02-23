package com.mveeramuthu.graph;

import java.util.LinkedList;
import java.util.Queue;

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
    
    public static int findMinMoves(int rows, int cols, 
                                   int startRow, int startCol, 
                                   int endRow, int endCol) { 
            /*
                 Approach: Graph BFS
                 T: O(rows * cols)
                 S: O(rows * cols)
                 
                // x and y direction, where a knight can move  
                // queue for storing states of knight in board  
                // make all cell unvisited  
                // visit starting state  
                // loop untill we have one element in queue  
                // if current cell is equal to target cell, return its distance
                // loop for all reachable states  
                // If reachable state is not yet visited and inside board, push that state into queue
            */
        
        Queue<Cell> queue = new LinkedList<>();
        
        
        
        
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
