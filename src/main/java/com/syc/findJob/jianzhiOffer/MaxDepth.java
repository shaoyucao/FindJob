package com.syc.findJob.jianzhiOffer;

/**
 * 二叉树的深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(null == root)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
