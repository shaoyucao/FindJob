package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {
    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * 双端队列
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(null == root)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> data = new LinkedList<>();
            while(n > 0) {
                TreeNode node = queue.pop();
                if(leftToRight)
                    data.offer(node.val);
                else
                    data.offerFirst(node.val);
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
                n--;
            }
            res.add(data);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
