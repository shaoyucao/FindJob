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
        //先进行一次前序遍历，并记录每个节点的父节点，存储形式为: {node, root}
        dfs(root, root);
        //获取从当前节点到根节点的路径
        LinkedList<TreeNode> pathOfP = getToRootPath(p, root);
        LinkedList<TreeNode> pathOfQ = getToRootPath(q, root);
        TreeNode res = root;
        //从后往前，依次比较
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

    //二叉树的最近公共祖先
    // 1.要么一个在左边，一个在右边，该种情况返回当前节点；
    // 2.要么两个在同一侧，则返回其中一个父节点，作为公共节点
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root)
            return null;
        if(p.val == root.val || q.val == root.val)
            return root;

        TreeNode findLeft = lowestCommonAncestor2(root.left, p, q);
        TreeNode findRight = lowestCommonAncestor2(root.right, p, q);

        if(findLeft != null && findRight != null)
            return root;
        if(findLeft == null) {
            return findRight;
        }
        else
            return findLeft;
    }
}
