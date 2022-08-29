package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class KthLargest {

    int res3, k;
    public int kthLargest(TreeNode root, int k) {
        if(null == root)
            return -1;
        this.k = k;
        inorderTravel(root);
        return res3;
    }

    public void inorderTravel(TreeNode root) {
        if(null == root)
            return;
        inorderTravel(root.right);
        if(k == 0)
            return;
        --k;
        if(k == 0) res3 = root.val;
        inorderTravel(root.left);
    }

    /////review

    /**
     * 思路：中序递归遍历将元素值存放到数组中，然后获取第n-k个元素
     * @param root
     * @param k
     * @return
     */
    ArrayList<Integer> list = new ArrayList<>();
    public int kthLargest2(TreeNode root, int k) {
        dfs(root);
        int n = list.size();
        return list.get(n-k);
    }

    public void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


    /**
     * 中序迭代遍历
     * @param root
     * @param k
     * @return
     */
    ArrayList<Integer> res = new ArrayList<>();
    public int kthLargest3(TreeNode root, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        while(!queue.isEmpty() || root != null) {
            while(root != null) {
                queue.add(root);
                root = root.left;
            }
            TreeNode node = queue.pollLast();
            res.add(node.val);
            root = node.right;
        }
        int n = res.size();
        return res.get(n-k);
    }

}
