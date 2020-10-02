package com.mveeramuthu.trees.bfs;

import com.mveeramuthu.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public void bfs(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            
            
        }
        
    }
    
    public static void main(String args[]) {
        
    }
}
