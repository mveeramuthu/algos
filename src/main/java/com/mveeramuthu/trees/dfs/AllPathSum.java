package com.mveeramuthu.trees.dfs;

/*
pathsofar
update path
manage update path
leaf node checks 
cleanup slate
 */

import com.mveeramuthu.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if(root == null) {
            return allPaths;
        }
        findPathsHelper(allPaths, new ArrayList<>(), root, sum);
        return allPaths;
    }

    private static void findPathsHelper(List<List<Integer>> allPaths, 
                                        List<Integer> currPath, TreeNode currNode, int sum) {
        if(currNode == null) {
            return;
        }

        currPath.add(currNode.value);

        if(currNode.value == sum && currNode.left == null && currNode.right == null) {
            // create a new list with path so far and add it to allpaths   
            allPaths.add(new ArrayList<>(currPath));
        } else {
            int remainingSum = sum - currNode.value;
            findPathsHelper(allPaths, currPath, currNode.left, remainingSum);
            findPathsHelper(allPaths, currPath, currNode.right, remainingSum);
        }
        
        currPath.remove(currPath.size() - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
