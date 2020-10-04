package com.mveeramuthu.trees.bfs;

/*
    Use stack or reverse while retrieving values from queue
 */

import com.mveeramuthu.ds.TreeNode;

import java.util.*;

public class BottomUpLevelOrderTraversal {
    public static List<List<Integer>> reverseBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Stack<List<Integer>> stack = new Stack<>();

        while(!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int queueSize = queue.size();

            for(int i=0; i<queueSize; i++) {
                TreeNode currNode = queue.poll();

                currLevel.add(currNode.value);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

            stack.add(currLevel);
        }
        
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(reverseBfs(root));
    }
}
