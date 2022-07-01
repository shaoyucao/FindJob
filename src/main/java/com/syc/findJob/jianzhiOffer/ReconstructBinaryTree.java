package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        return reBuildBinaryTree(preorder, inorder, 0, 0, n);

    }

    private TreeNode reBuildBinaryTree(int[] preOrder, int[] inOrder, int preorderL, int inorderL, int length) {
        if(length == 0)
            return null;

        int rootValue = preOrder[preorderL];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderL;
        while(rootIndex < inorderL+length) {
            if(inOrder[rootIndex] == rootValue)
                break;
            rootIndex++;
        }

        int leftLength = rootIndex-inorderL;

        root.left = reBuildBinaryTree(preOrder, inOrder, preorderL+1, inorderL, leftLength);
        root.right = reBuildBinaryTree(preOrder, inOrder, preorderL+leftLength+1, rootIndex+1, length-leftLength-1);

        return root;
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = new ReconstructBinaryTree().buildTree(preorder, inorder);

        System.out.println(TreeNodeUtil.printTreeNodeByLevel(treeNode));
    }
}
