package com.syc.findJob.jianzhiOffer;

/**
 * 序列化二叉树
 */
public class Codec {
    StringBuilder sb = new StringBuilder();
    char[] c;
    int index = -1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(null == root)
            return null;
        dfs(root);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void dfs(TreeNode root) {
        if(null == root) {
            sb.append("$,");
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data)
            return null;
        String[] strs = data.split(",");
        return deserialize(strs);
    }

    public TreeNode deserialize(String[] strs){
        ++index;
        if(strs[index].equals("$")) {
            return null;
        }
        int val = Integer.valueOf(strs[index]);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(strs);
        root.right = deserialize(strs);
        return root;
    }
}
