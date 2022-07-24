package com.syc.findJob.jianzhiOffer;

import java.util.LinkedList;
import java.util.List;

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if(null == root) {
            return null;
        }

        swapLeftAndRigt(root);

        return root;

    }

    public void swapLeftAndRigt(TreeNode root){
        if(null == root)
            return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        swapLeftAndRigt(root.left);
        swapLeftAndRigt(root.right);
    }

    public TreeNode mirrorTree2(TreeNode root) {

        if(null == root)
            return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.removeFirst();
            if(curr.left != null)
                queue.addLast(curr.left);
            if(curr.right != null)
                queue.addLast(curr.right);
            TreeNode left = curr.left;
            curr.left = curr.right;
            curr.right = left;
        }

        return root;
    }


    ///////////////  review

    /**
     * 递归方法
     * @param root
     * @return
     */
    public TreeNode mirrorTree3(TreeNode root) {
        if(null == root)
            return null;
        TreeNode left = root.left;
        root.left = mirrorTree3(root.right);
        root.right = mirrorTree3(left);
        return root;
    }

    public TreeNode mirrorTree4(TreeNode root) {
        if(null == root)
            return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            swap(cur);
            if(null != cur.left)
                queue.addLast(cur.left);
            if(null != cur.right)
                queue.addLast(cur.right);
        }
        return root;
    }

    public void swap(TreeNode root) {
        if(!(null == root.left && null == root.right)) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = right;
        }
    }

}
