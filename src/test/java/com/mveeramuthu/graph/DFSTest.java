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

    public AdjacencyMatrixDirectedGraph buildAdjacencyMatrixDirectedGraph() {
        AdjacencyMatrixDirectedGraph graph = new AdjacencyMatrixDirectedGraph(3, 3);
        graph.adjMatrix = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        return graph;
    }
    
    // ******************** Adjacency list - iterative ********************
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

    // ******************** Adjacency list - recursive ********************
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

    // ******************** Adjacency matrix - iterative ********************
    @Test
    public void adjMatrixIterativeStartFrom0Test() {
        AdjacencyMatrixDirectedGraph graph = buildAdjacencyMatrixDirectedGraph();
        graph.dfsIterative(graph, 0);
    }

    @Test
    public void adjMatrixIterativeStartFrom1Test() {
        AdjacencyMatrixDirectedGraph graph = buildAdjacencyMatrixDirectedGraph();
        graph.dfsIterative(graph, 1);
    }

    @Test
    public void adjMatrixIterativeStartFrom2Test() {
        AdjacencyMatrixDirectedGraph graph = buildAdjacencyMatrixDirectedGraph();
        graph.dfsIterative(graph, 2);
    }
}
