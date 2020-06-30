package com.yefan.study.algorithm.tree;

/**
 * 是否是平衡树 节点的左右高度差小于 1
 * @author yefan
 */
public class IsBalance {

    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    /**
     * 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //终止点
        if (root == null) {
            return 0;
        }
        //递归
        int rDepth = maxDepth(root.right);
        int lDepth = maxDepth(root.left);
        //深度差绝对值
        if(Math.abs(rDepth - lDepth) > 1){
            result = false;
        }
        return Math.max(rDepth, lDepth) + 1;
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
