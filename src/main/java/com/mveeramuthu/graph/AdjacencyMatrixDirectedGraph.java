package com.mveeramuthu.graph;

public class AdjacencyMatrixDirectedGraph {
    public int rows;
    public int cols;
    public int[][] adjMatrix;

    public AdjacencyMatrixDirectedGraph(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        adjMatrix = new int[rows][cols];
    }

    public void addEdge(AdjacencyMatrixDirectedGraph graph,
                            int row, int col) {
        adjMatrix[row][col] = 1;
    }

    public void print(AdjacencyMatrixDirectedGraph graph) {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.print(adjMatrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
