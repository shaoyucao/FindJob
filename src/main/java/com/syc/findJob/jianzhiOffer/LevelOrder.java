package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        if(null == root)
            return new int[0];

        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }

        int size = list.size();

        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
