package com.syc.findJob.jianzhiOffer;

/**
 * 路径总和
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if(root.val == targetSum && root.left == null && root.right == null)
            return true;

        boolean hasLeft = hasPathSum(root.left, targetSum-root.val);
        boolean hasRight = hasPathSum(root.right, targetSum-root.val);
        return hasLeft || hasRight;
    }
}
