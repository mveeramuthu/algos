package com.mveeramuthu.trees.dfs;

import com.mveeramuthu.ds.TreeNode;

public class FindPath {
    public static boolean hasPath(TreeNode root, int[] sequence) {
        if(root == null) {
            return false;
        }
        
        return hasPathHelper(root, sequence, 0); 
    }

    private static boolean hasPathHelper(TreeNode currNode, int[] sequence, int index) {
        if(currNode == null) {
            return false;
        }
        
        if(index >= sequence.length || currNode.value != sequence[index]) {
            return false;
        }

        if(index == sequence.length-1 && currNode.left == null && currNode.right == null) {
            return true;
        }

        index++;

        return hasPathHelper(currNode.left, sequence, index) 
                || hasPathHelper(currNode.right, sequence, index);
    }
    
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path sequence: " + hasPath(root, new int[] {1, 9, 9}));
        System.out.println("Tree has path sequence: " + hasPath(root, new int[] {1, 1, 6}));
    }
}
