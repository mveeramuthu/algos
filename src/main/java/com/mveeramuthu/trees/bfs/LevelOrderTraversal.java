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
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
    }
}
