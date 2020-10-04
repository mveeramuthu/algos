package com.mveeramuthu.trees.bfs;

import com.mveeramuthu.ds.TreeNode;
import java.util.*;
import static com.mveeramuthu.trees.bfs.LevelOrderTraversal.bfs;

public class ZigZagLevelOrderTraversal {
    /*public static List<List<Integer>> zigZagBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        boolean leftToRight = false;
        
        while(!deque.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int queueSize = deque.size();

            for(int i=0; i<queueSize; i++) {
                TreeNode currNode = deque.poll();

                currLevel.add(currNode.value);

                if(leftToRight) {
                    if (currNode.left != null) {
                        deque.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.addLast(currNode.right);
                    }
                } else {
                    if (currNode.left != null) {
                        deque.addFirst(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.addFirst(currNode.right);
                    }
                }
                
                leftToRight = !leftToRight;
            }

            result.add(currLevel);
        }

        return result;
    }*/

    public static List<List<Integer>> zigZagBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int queueSize = queue.size();

            for(int i=0; i<queueSize; i++) {
                TreeNode currNode = queue.poll();
                
                if(leftToRight) {
                    currLevel.add(currNode.value);
                } else {
                    currLevel.add(0, currNode.value);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(currLevel);
            leftToRight = !leftToRight;
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        System.out.println(bfs(root));
        System.out.println();
        System.out.println(zigZagBfs(root));
    }
}
