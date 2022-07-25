package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class PreorderTraversal {
    List<Integer> res = new ArrayList<>();

    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null == root)
            return res;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if(null == root)
            return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 迭代，栈，先入右节点
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(null == root)
            return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if(null != node.right)
                stack.push(node.right);
            if(null != node.left)
                stack.push(node.left);
        }
        return res;
    }

    /**
     * 迭代，栈，先入左节点
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(null == root)
            return res;
        TreeNode node = root;
        while(!stack.isEmpty() || null != node) {
            while(null != node) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().right;
        }
        return res;
    }
}
