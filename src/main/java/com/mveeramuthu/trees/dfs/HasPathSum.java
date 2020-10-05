package com.mveeramuthu.trees.dfs;

import com.mveeramuthu.ds.TreeNode;

/*
    if(totalSum - currValue == 0 && if leaf node) {
        return true;
    }

 */
public class HasPathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        // node value is equal to sum and it should be a leaf node    
        if(root.value == sum && root.left == null && root.right == null) {
            return true;
        }

        int remainingSum = sum - root.value;
        return hasPath(root.left, remainingSum) || hasPath(root.right, remainingSum);
    }
    
    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }
}
