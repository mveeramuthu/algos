package com.mveeramuthu.z.oci;

import com.mveeramuthu.ds.TreeNode;

class LcaBst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2) {
        if (t1.value > root.value && t2.value > root.value) {
            return lowestCommonAncestor(root.right, t1, t2);
        }

        if (t1.value < root.value && t2.value < root.value) {
            return lowestCommonAncestor(root.left, t1, t2);
        }

        return root;
    }
}
