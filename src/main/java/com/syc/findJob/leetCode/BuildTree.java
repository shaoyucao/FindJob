package com.syc.findJob.leetCode;

import java.util.Arrays;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return reBuildTree(preorder, inorder);
    }

    public TreeNode reBuildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0)
            return null;

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int length = inorder.length;
        int index = 0;
        while(index < length && inorder[index] != rootValue) {
            index++;
        }

        int[] leftInorder = Arrays.copyOf(inorder, index);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index);

        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, length-1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, index+1, length-1);

        root.left = reBuildTree(leftPreorder, leftInorder);
        root.right = reBuildTree(rightPreorder, rightInorder);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        int[] arr2 = Arrays.copyOf(arr, 0);
        System.out.println(Arrays.toString(arr2));
    }
}
