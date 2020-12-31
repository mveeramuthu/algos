package com.mveeramuthu.z.oci;

import com.mveeramuthu.ds.TreeNode;

class BinaryTreeSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        return (tree1.value == tree2.value)
            && isSymmetric(tree1.right, tree2.left)
            && isSymmetric(tree1.left, tree2.right);
    }
}
