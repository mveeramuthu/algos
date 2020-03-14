package com.mveeramuthu.z.google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph {

    int verticesCnt;
    List<Integer>[] adjVertices;

    Graph(int verticesCnt) {
        this.verticesCnt = verticesCnt;
        this.adjVertices = new LinkedList[verticesCnt];

        for (int i=0; i<verticesCnt; i++) {
            adjVertices[i] = new LinkedList<>();
        }
    }

    // Add edge in graph between vertices
    void addEdge(int vertex1, int vertex2) {
        this.adjVertices[vertex1].add(vertex2);
    }
}

public class GraphTraversal {

    public static void dfs(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.verticesCnt];
        dfsHelper(graph, startVertex, visited);
    }

    private static void dfsHelper(Graph graph, int startVertex, boolean[] visited) {

        System.out.print(startVertex + " -> ");

        // start index is visited
        visited[startVertex] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer>  iterator = graph.adjVertices[startVertex].listIterator();

        while(iterator.hasNext()) {
            int nextVertex = iterator.next();
            if(!visited[nextVertex]) {
                dfsHelper(graph, nextVertex, visited);
            }
        }

        System.out.println();
    }

    private static void dfsUsingStack(Graph graph, int startVertex) {

        boolean[] visited = new boolean[graph.verticesCnt];
        int currVertex = startVertex;

        // Create stack for dfs
        Stack<Integer> stack = new Stack<>();
        stack.push(currVertex);

        while (!stack.isEmpty()) {

            currVertex = stack.pop();

            for (int i=0; i<visited.length; i++) {
                System.out.print(i + "=" + visited[i] + ", ");
            }
            System.out.println();

            //System.out.println(currVertex + " - " + visited[currVertex]);

            if(!visited[currVertex]) {
                System.out.print(startVertex + " -> ");
                visited[currVertex] = true;
            }

            System.out.println();

            //System.out.println(currVertex + " - " + visited[currVertex]);

            // push adjacent vertices into stack
            Iterator<Integer> iterator = graph.adjVertices[currVertex].listIterator();

            while (iterator.hasNext()) {
                int nextVertex = iterator.next();
                if(!visited[nextVertex]) {
                    stack.push(nextVertex);
                }
            }
        }

        System.out.println();
    }

    public static void main(String args[]) {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        //dfs(graph, 0);
        dfsUsingStack(graph, 0);

    }
}
