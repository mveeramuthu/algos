package com.mveeramuthu.trees.bfs;

import com.mveeramuthu.ds.NaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryLevelOrderTraversal {
    public static List<List<Integer>> bfs(NaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int levelNodeCount = queue.size();
            List<Integer> levelList = new ArrayList<>(levelNodeCount);

            for(int i=0; i<levelNodeCount; i++) {
                NaryTreeNode currNode = queue.poll();
                levelList.add(currNode.value);

                if(currNode.children != null) {
                    currNode.children.forEach(queue::add);
                }
            }
            
            result.add(levelList);
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        NaryTreeNode root = new NaryTreeNode(12);
        root.children.add(new NaryTreeNode(7));
        root.children.add(new NaryTreeNode(1));

        System.out.println(bfs(root));
    }
}
