package com.syc.findJob.jianzhiOffer;

import java.util.LinkedList;

public class MaxDepth_Review {

    /**
     * 递归
     * 时间复杂度O(n), 空间复杂度O(log(n))
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }

    /**
     * 层序遍历，非递归方式
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        int ans = 0;
        if(root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode temp = queue.pollFirst();
                if(temp.left != null) {
                    queue.addLast(temp.left);
                }
                if(temp.right != null) {
                    queue.addLast(temp.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


}
