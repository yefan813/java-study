package com.yefan.study.algorithm.tree;

/**
 * @author yefan
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        //不相等 则不对称
        if(t1.data != t2.data) {
            return false;
        }
        //相等继续判断后续子节点
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
