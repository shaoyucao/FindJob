package com.syc.findJob.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 */
public class BuildTree {
    /**
     * 时间复杂度O(n),空间复杂度O(n)(树的节点数+哈希表的空间）
     * 使用哈希表对查找根节点的时间性能进行优化
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> rootMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || null == inorder || preorder.length == 0 || inorder.length == 0)
            return null;
        for(int i = 0; i < inorder.length; ++i) {
            rootMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int prel, int prer, int inl, int inr) {
        if(prel > prer)
            return null;
        int rootVal = preorder[prel];
        int index = rootMap.get(rootVal);
        int leftLen = index - inl;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(preorder, inorder, prel+1, prel+leftLen, inl, index-1);
        root.right = dfs(preorder, inorder, prel+leftLen+1, prer,index+1, inr);
        return root;
    }
}
