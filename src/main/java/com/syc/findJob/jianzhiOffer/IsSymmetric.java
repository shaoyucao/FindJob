package com.syc.findJob.jianzhiOffer;

import java.util.LinkedList;

/**
 * 对称的二叉树
 */
public class IsSymmetric {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if(null == root)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(null == left && null == right)
            return true;
        if(null == left || null == right)
            return false;
        if(left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();

            if(null == u && null == v)
                continue;

            if(null == u || null == v || u.val != v.val)
                return false;

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);

        }
        return true;
    }
}
