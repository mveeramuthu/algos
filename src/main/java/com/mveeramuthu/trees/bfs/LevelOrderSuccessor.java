package com.mveeramuthu.trees.bfs;

import com.mveeramuthu.ds.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            
            if (currNode.right != null) {
                queue.add(currNode.right);
            }

            if(currNode.value == key) {
                break;
            }
        }

        return queue.peek();
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(findSuccessor(root, 12));
    }
}
