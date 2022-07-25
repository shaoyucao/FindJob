package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后续遍历
 */
public class PostorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(null == root)
            return res;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if(null == node)
            return;
        dfs(node.left);
        dfs(node.right);
        res.add(node.val);
    }

    /**
     * 迭代写法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(null == root)
            return res;
        TreeNode pre = null;
        while(!stack.isEmpty() || null != root) {
            while(null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(null == root.right || root.right == pre) {
                res.add(root.val);
                pre = root;
                root = null;
            }
            else{
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
