package com.mveeramuthu.graph.dfs;

import com.mveeramuthu.ds.Pair;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        /*
            1. if a 'O' cell is present in the border, it definitely is not surrounded.
            2. there can be many other 'O' cells connected with the 'O' cell from border
         */

        // find borders
        List<Pair<Integer, Integer>> borders = new ArrayList<>();

        for(int i=0; i<row; i++) {
            borders.add(new Pair<>(i, 0)); //first row
            borders.add(new Pair<>(i, col-1)); //last row
        }

        for(int j=0; j<col; j++) {
            borders.add(new Pair<>(0, j)); //first col
            borders.add(new Pair<>(row-1, j)); //last col
        }

        print(board);
        System.out.println(borders);

        // mark 'O' cells in border with 'U' (for unbounded) and
        // do a DFS from that cell to find all connected 'O's
        for(var borderCell : borders) {
            dfs(board, borderCell.getFirst(), borderCell.getSecond());
        }

        // figure out which of the 'U's are 'X's
        // if there are any more 'O's, then they should be changed to 'X's
        // all 'U's should be changed to 'O's
        for(int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'U') {
                    board[i][j] = 'O';
                }
            }
        }

        print(board);
    }

    private static void dfs(char[][] board, int currRow, int currCol) {
        if(board[currRow][currCol] != 'O') {
            return;
        }

        board[currRow][currCol] = 'U';

        int row = board.length;
        int col = board[0].length;

        if(currRow > 0) {
            dfs(board, currRow - 1, currCol);
        }

        if(currCol > 0) {
            dfs(board, currRow, currCol - 1);
        }

        if(currRow < row-1) {
            dfs(board, currRow + 1, currCol);
        }

        if(currCol < col-1) {
            dfs(board, currRow, currCol + 1);
        }
    }

    private static void print(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        solve(new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        });
    }
}
