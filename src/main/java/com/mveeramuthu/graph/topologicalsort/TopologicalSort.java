package com.mveeramuthu.graph.topologicalsort;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {
    public static List<Integer> sort(int[][] graph) throws Exception {
        List<Integer> sortedVertices = new ArrayList<>();
        if(graph == null || graph.length <= 0) {
            return sortedVertices;
        }
        
        int verticesCount = graph.length;
        
        // vertex in-degree
        Map<Integer, Integer> indegree = new HashMap<>();
        
        // convert matrix graph to adjacency list 
        Map<Integer, List<Integer>> graphAdjListMap = new HashMap<>();

        for(int i = 0; i < verticesCount; i++) {
            indegree.put(i, 0);
            graphAdjListMap.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < verticesCount; i++) {
            int parent = graph[i][0];
            int child = graph[i][1];
            
            // add child to the parent's neighbor list
            graphAdjListMap.get(parent).add(child);
            
            // increase in-degree for the child node
            indegree.put(child, indegree.get(child) + 1);
        }
        
        // find all sources i.e. vertices with 0 in-degree
        // TODO: why queue? To check if there is a cycle?
        Queue<Integer> sourceQueue = indegree
                .values()
                .stream()
                .filter(value -> value != 0)
                .collect(Collectors.toCollection(LinkedList::new));
        
        // add sources to the sorted list 
        // and decrease all it's children's in-degree
        while(!sourceQueue.isEmpty()) {
            int vertex = sourceQueue.poll();
            sortedVertices.add(vertex);
            graphAdjListMap.get(vertex)
                    .forEach(child -> {
                        indegree.put(child, indegree.get(child) - 1);
                        
                        if(indegree.get(child) == 0) {
                            sourceQueue.add(child);
                        }
                    });
        }
        
        // check if graph has cycle
        if(sortedVertices.size() != verticesCount) {
            throw new Exception("Error: Topological sort not possible because graph has a cycle");
        }
        
        return sortedVertices;
    }
    
    public static void  main(String args[]) {
        int[][] graph = new int[][] {
                                        new int[]{3, 2},
                                        new int[]{3, 0},
                                        new int[]{2, 0},
                                        new int[]{2, 1},                
                        };
        try {
            sort(graph)
                    .forEach(value -> System.out.print(value + ", "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
