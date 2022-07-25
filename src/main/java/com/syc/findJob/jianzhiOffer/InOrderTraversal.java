package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InOrderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root)
            return res;
        dfs(root);
        return res;
    }

    /**
     * 递归
     * @param node
     */
    public void dfs(TreeNode node) {
        if(null == node)
            return;
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || null != node) {
            while(null != node) {
                stack.push(node);
                node = node.left;
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            node = temp.right;
        }
        return res;
    }
}
