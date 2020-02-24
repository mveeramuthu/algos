package com.mveeramuthu.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListDirectedGraph { 
    public int verticesCount;
    public List<List<Integer>> adjList;

    public AdjacencyListDirectedGraph(int verticesCount) {
        this.verticesCount = verticesCount;
        this.adjList = new ArrayList<>(verticesCount);
        for(int i=0; i<verticesCount; i++) {
            adjList.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(AdjacencyListDirectedGraph graph,
                                   int src, int dest) {
        graph.adjList.get(src).add(dest);
        graph.adjList.get(dest).add(src);
    }
    
    public void print(AdjacencyListDirectedGraph graph) {
        for(int i=0; i<graph.verticesCount; i++) {
            System.out.print("start");
            for (Integer vertex : graph.adjList.get(i)) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }
}
