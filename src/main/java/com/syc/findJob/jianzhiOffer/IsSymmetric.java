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

    //////////////////// review

    public boolean isSymmetric3(TreeNode root) {
        if(null == root)
            return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first.val != second.val)
                return false;
            if(null != first.left && null != second.right){
                queue.offer(first.left);
                queue.offer(second.right);
            }
            if(null != first.right && null != second.left){
                queue.offer(first.right);
                queue.offer(second.left);
            }
            if(null == first.left && null != second.right ||
                    null != first.left && null == second.right)
                return false;
        }
        return true;
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isSymmetric4(TreeNode root) {
        if(null == root)
            return true;
        return isSymmetric4(root, root);
    }

    public boolean isSymmetric4(TreeNode u, TreeNode v) {
        if(null == u && null != v || null != u && null == v)
            return false;
        else if(null == u && null == v)
            return true;
        else if(u.val != v.val)
            return false;
        return isSymmetric4(u.left, v.right) && isSymmetric4(u.right, v.left);
    }
}
