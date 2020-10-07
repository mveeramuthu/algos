package com.mveeramuthu.trees.dfs;

import com.mveeramuthu.ds.TreeNode;

public class AllPathNumbersSum {
    public static int findSumOfPathNumbers(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE; // throw error
        }
        return findSumOfPathNumbersHelper(root, 0);
    }

    private static int findSumOfPathNumbersHelper(TreeNode currNode, int pathSum) {
        if(currNode == null) {
            return 0;
        }
        
        pathSum = 10 * pathSum + currNode.value;
        
        if(currNode.left == null && currNode.right == null) {
            return pathSum;
        }
        
        return findSumOfPathNumbersHelper(currNode.left, pathSum) + findSumOfPathNumbersHelper(currNode.right, pathSum);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
    }
}
