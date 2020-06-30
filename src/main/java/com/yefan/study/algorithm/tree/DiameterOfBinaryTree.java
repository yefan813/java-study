package com.yefan.study.algorithm.tree;


/**
 * 树中两个节点最长是多少
 * @author yefan
 */
public class DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        // final node
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        //最长路径就是左边深度和右边深度相加，去个最大值
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }

    public class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
