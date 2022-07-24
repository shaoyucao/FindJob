package com.syc.findJob.jianzhiOffer;

/**
 * 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    /**
     * 中序递归遍历
     */
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if(null == root)
            return null;
        dfs(root);
        pre.right = head; //扫尾处理
        head.left = pre;
        return head;
    }

    public void dfs(Node cur) {
        if(null == cur)
            return;
        dfs(cur.left); //左
        cur.left = pre; //根
        if(null != pre) {
            pre.right = cur;
        }
        else{
            head = cur;
        }
        pre = cur;
        dfs(cur.right); //右
    }
}
