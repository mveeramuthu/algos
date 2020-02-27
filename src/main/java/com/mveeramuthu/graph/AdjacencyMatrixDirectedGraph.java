package com.mveeramuthu.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class AdjacencyMatrixDirectedGraph {
    public int rows;
    public int cols;
    public int[][] adjMatrix;
    public int verticesCount;

    public AdjacencyMatrixDirectedGraph(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        adjMatrix = new int[rows][cols];
        verticesCount = rows * cols;
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

    public void dfsIterative(AdjacencyMatrixDirectedGraph graph, int startVertex) {
        boolean[] visited = new boolean[verticesCount];

        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currVertex = stack.pop();

            if(!visited[currVertex]) {
                System.out.print(currVertex + " -> ");
                visited[currVertex] = true;
            }

            for(int j=0; j<cols; j++) {
                if(!visited[j] && graph.adjMatrix[currVertex][j] == '1') {
                    visited[j] = true;
                    stack.push(j);
                }
            }
        }
        System.out.println();
    }
}
