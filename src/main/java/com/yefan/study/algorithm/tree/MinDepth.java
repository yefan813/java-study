package com.yefan.study.algorithm.tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //1.当前就是叶子节点
        if(root.left == null && root.right == null) {
            return 1;
        }

        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);
        //当前节点不是叶子节点，且其中有一边为空
        if(lDepth == 0 || rDepth ==0){
            return lDepth + rDepth + 1;
        }
        return Math.min(lDepth, rDepth) + 1;
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
