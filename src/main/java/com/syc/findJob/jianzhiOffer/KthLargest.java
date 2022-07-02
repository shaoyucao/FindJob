package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        if(null == root)
            return -1;
        this.k = k;
        inorderTravel(root);
        return res;
    }

    public void inorderTravel(TreeNode root) {
        if(null == root)
            return;
        inorderTravel(root.right);
        if(k == 0)
            return;
        --k;
        if(k == 0) res = root.val;
        inorderTravel(root.left);
    }
}
