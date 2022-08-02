package com.syc.findJob.jianzhiOffer;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    /**
     * 时间复杂度O(n), 空间复杂度O(n)
     * 使用哈希表存储所有节点的父节点，获得从根节点到所查询节点的路径
     * @param root
     * @param p
     * @param q
     * @return
     */

    Map<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root)
            return null;
        dfs(root, root);
        LinkedList<TreeNode> pathOfP = getToRootPath(p, root);
        LinkedList<TreeNode> pathOfQ = getToRootPath(q, root);
        TreeNode res = root;
        while(pathOfQ.peekLast() == pathOfP.peekLast()) {
            res = pathOfP.pollLast();
            pathOfQ.pollLast();
        }
        return res;
    }

    public void dfs(TreeNode root, TreeNode pre) {
        if(null == root)
            return;
        map.put(root, pre);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public LinkedList<TreeNode> getToRootPath(TreeNode node, TreeNode root) {
        LinkedList<TreeNode> res = new LinkedList<>();
        while(node != root) {
            res.add(node);
            node = map.get(node);
        }
        res.add(root);
        return res;
    }



//    public List<TreeNode> dfs(TreeNode root, TreeNode node) {
//        List<TreeNode> list = new ArrayList<>();
//        if(null == root)
//            return list;
//        list.add(root);
//        if(root == node)
//            return;
//        dfs(root.left, node, list);
//        dfs(root.right, node, list);
//        list.remove(list.size()-1);
//    }
}
