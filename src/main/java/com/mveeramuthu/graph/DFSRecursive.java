package com.mveeramuthu.graph;

import java.util.Iterator;

public class DFSRecursive {   
    
    public void dfs(AdjacencyListDirectedGraph graph, int startVertex) {
        boolean[] visited = new boolean[graph.verticesCount];
        dfsHelper(graph, startVertex, visited);
        System.out.println();
    }
    
    public void dfsHelper(AdjacencyListDirectedGraph graph, 
                          int currVertex, boolean[] visited) {
        visited[currVertex] = true;
        System.out.print(currVertex + " -> ");

        Iterator<Integer> currNeighborVertex =  graph.adjList.get(currVertex).listIterator();
        while(currNeighborVertex.hasNext()) {
            int nextNeighborVertex = currNeighborVertex.next();
            if(!visited[nextNeighborVertex]) {
                dfsHelper(graph, nextNeighborVertex, visited);
            }
        }
    }
}
