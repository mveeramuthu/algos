package com.mveeramuthu.graph;

import org.junit.Test;

public class DFSRecursiveTest { 
    
    public AdjacencyListDirectedGraph buildGraph() {
        AdjacencyListDirectedGraph graph = new AdjacencyListDirectedGraph(4);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 3);
        return graph;
    }
    
    @Test
    public void startFrom0Test() {
        AdjacencyListDirectedGraph graph = buildGraph();
        DFSRecursive dfsRecursive = new DFSRecursive();
        dfsRecursive.dfs(graph, 0);
    }

    @Test
    public void startFrom1Test() {
        AdjacencyListDirectedGraph graph = buildGraph();
        DFSRecursive dfsRecursive = new DFSRecursive();
        dfsRecursive.dfs(graph, 1);
    }

    @Test
    public void startFrom2Test() {
        AdjacencyListDirectedGraph graph = buildGraph();
        DFSRecursive dfsRecursive = new DFSRecursive();
        dfsRecursive.dfs(graph, 2);
    }

    @Test
    public void startFrom3Test() {
        AdjacencyListDirectedGraph graph = buildGraph();
        DFSRecursive dfsRecursive = new DFSRecursive();
        dfsRecursive.dfs(graph, 3);
    }
}
