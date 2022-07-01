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

}
