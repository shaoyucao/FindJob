package com.syc.findJob.jianzhiOffer;

import java.util.*;

public class TreeNodeUtil {

    public static List<Integer> printTreeNodeByLevel(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(null == root)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.removeFirst();
            res.add(top.val);
            if(top.left != null)
                queue.addLast(top.left);
            if(top.right != null)
                queue.addLast(top.right);
        }
        return res;
    }

//    public static TreeNode createBinaryTreeByArray(Integer[] array) {
//        if(null == array || array.length == 0)
//            return null;
//        int len = array.length;
//        TreeNode root = new TreeNode(array[0]);
//        TreeNode head = root;
//        int index = 0;
//        while(index < len) {
//            root = new TreeNode(array[index]);
//            if(index * 2 + 1 < len)
//                root.left = new TreeNode(array[index * 2 + 1]);
//            if(index * 2 + 2 < len)
//                root.right = new TreeNode(array[index * 2 + 2]);
//            index++;
//
//        }
//        return head;
//    }


}
