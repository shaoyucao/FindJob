package com.syc.findJob.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
    }


    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        return dfs(root, stack);
    }

    public boolean dfs(TreeNode root, Stack<TreeNode> stack) {
        if(root == null){
            return true;
        }
        if(!dfs(root.left, stack)){
            return false;
        }
        if(stack.isEmpty()) {
            stack.push(root);
        }
        else{
            if(root.val < stack.pop().val)
                return false;
            stack.push(root);
        }
        return dfs(root.right, stack);
    }

}
