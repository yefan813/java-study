package com.yefan.study.algorithm.tree;

/**
 * 是否有路径中节点的值相加 等于 target
 * @author yefan
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null ) {
            return false;
        }
        sum = sum - root.val;
        if(root.left == null && root.right == null){
            return (sum == 0);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
