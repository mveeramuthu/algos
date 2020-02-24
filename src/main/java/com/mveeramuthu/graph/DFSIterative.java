package com.mveeramuthu.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFSIterative { 
    public void dfs(AdjacencyListDirectedGraph graph, int startVertex) {
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
}
