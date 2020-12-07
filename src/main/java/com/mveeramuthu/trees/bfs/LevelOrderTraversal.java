package com.mveeramuthu.trees.bfs;

import com.mveeramuthu.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

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

            result.add(currLevel);
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

        System.out.println(bfs(root));
    }
}
