package com.mveeramuthu.graph.topologicalsort;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {
    
    /*
        tasks = vartices
        prereqs = edges
        
        if there is a cyclic dependency, it is not possible to schedule the tasks
        => do a topological sort
            
     */
    
    public static boolean canSchedule(int tasks, int[][] prereqs) {
        if(prereqs == null || prereqs.length <= 0) {
            return false;
        }
        
        //int prereqCount = prereqs.length;
        Map<Integer, List<Integer>> taskGraph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for(int i = 0; i < tasks; i++) {
            taskGraph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for(int i = 0; i < prereqs.length; i++) {
            int parent = prereqs[i][0];
            int child = prereqs[i][1];

            taskGraph.get(parent).add(child);
            indegree.put(child, indegree.get(child) + 1);
        }

        Queue<Integer> sourceQueue = indegree
                .values()
                .stream()
                .filter(value -> value != 0)
                .collect(Collectors.toCollection(LinkedList::new));
        
        List<Integer> sortedTasks = new ArrayList<>();
        while(!sourceQueue.isEmpty()) {
            int task = sourceQueue.poll();
            sortedTasks.add(task);

            taskGraph.get(task)
                    .forEach(child -> {
                        indegree.put(child, indegree.get(child) - 1);
                        
                        if(indegree.get(child) == 0) {
                            sourceQueue.add(child);
                        }
                    });
        }
        
        if(sortedTasks.size() != tasks) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        System.out.println(canSchedule(3, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2}
        }));
    }
}
