package com.mveeramuthu.graph;

import org.junit.Test;

public class DFSTest { 
    
    public AdjacencyListDirectedGraph buildAdjacencyListDirectedGraph() {
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
    public void adjListIterativeStartFrom0Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsIterative(graph, 0);
    }

    @Test
    public void adjListIterativeStartFrom1Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsIterative(graph, 1);
    }

    @Test
    public void adjListIterativeStartFrom2Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsIterative(graph, 2);
    }

    @Test
    public void adjListIterativeStartFrom3Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsIterative(graph, 3);
    }

    @Test
    public void adjListRecursiveStartFrom0Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsRecursive(graph, 0);
    }

    @Test
    public void adjListRecursivetartFrom1Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsRecursive(graph, 1);
    }

    @Test
    public void adjListRecursivetartFrom2Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsRecursive(graph, 2);
    }

    @Test
    public void adjListRecursivetartFrom3Test() {
        AdjacencyListDirectedGraph graph = buildAdjacencyListDirectedGraph();
        graph.dfsRecursive(graph, 3);
    }
}
