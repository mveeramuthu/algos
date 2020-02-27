package com.mveeramuthu.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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

    public void dfsIterative(AdjacencyListDirectedGraph graph, int startVertex) {
        List<Boolean> visited = new ArrayList<>(graph.verticesCount);
        for(int i=0; i<graph.verticesCount; i++) {
            visited.add(false);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currVertex = stack.pop();
            if(!visited.get(currVertex)) {
                System.out.print(currVertex + " -> ");
                visited.set(currVertex, true);
            }
            Iterator<Integer> currNeighborVertex = graph.adjList.get(currVertex).listIterator();
            while(currNeighborVertex.hasNext()) {
                int nextNeighborVertex = currNeighborVertex.next();
                if(!visited.get(nextNeighborVertex)) {
                    stack.push(nextNeighborVertex);
                }
            }
        }
        System.out.println();
    }
    
    public void dfsRecursive(AdjacencyListDirectedGraph graph, int startVertex) {
        boolean[] visited = new boolean[graph.verticesCount];
        dfsRecursiveHelper(graph, startVertex, visited);
        System.out.println();
    }

    public void dfsRecursiveHelper(AdjacencyListDirectedGraph graph,
                          int currVertex, boolean[] visited) {
        visited[currVertex] = true;
        System.out.print(currVertex + " -> ");

        Iterator<Integer> currNeighborVertex =  graph.adjList.get(currVertex).listIterator();
        while(currNeighborVertex.hasNext()) {
            int nextNeighborVertex = currNeighborVertex.next();
            if(!visited[nextNeighborVertex]) {
                dfsRecursiveHelper(graph, nextNeighborVertex, visited);
            }
        }
    }
}
