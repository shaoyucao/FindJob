package com.syc.findJob.jianzhiOffer;

public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode treeNode) {

        if(treeNode == null)
            return null;

        //有右孩子
        if(treeNode.right != null) {
            treeNode = treeNode.right;
            while(treeNode.left != null)
                treeNode = treeNode.left;
            return treeNode;
        }

        //没有右孩子（1）如果该节点为父节点的左节点，则返回父节点；（2）如果不是父节点的左孩子，则一直向上找，直到找到一个节点为父节点的左节点
        while(treeNode.next != null) {
            if(treeNode.next.left == treeNode) {
                return treeNode.next;
            }
            treeNode = treeNode.next;
        }

        //如果是最后一个节点，则返回下一个节点为空
        return null;
    }

    // review
    public TreeLinkNode getNext2(TreeLinkNode treeNode) {

        if(treeNode == null) {
            return null;
        }

        if(treeNode.right != null) {
            return getLeftest(treeNode.right);
        }

        //剩下就是右节点为空的情况

//        if(treeNode.next != null && treeNode == treeNode.next.left) {
//            return treeNode.next;
//        }
//
//        if(treeNode.next != null && treeNode == treeNode.next.right) {
//            return getUpLeft(treeNode);
//        }

        while(treeNode.next != null) {
            if(treeNode.next.left == treeNode) {
                return treeNode.next;
            }
            treeNode = treeNode.next;
        }

        return null;
    }

    public TreeLinkNode getLeftest(TreeLinkNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeLinkNode getUpLeft(TreeLinkNode node) {
        while(node.next != null) {
            node = node.next;
            if(node.next != null && node == node.next.left) {
                return node.next;
            }
        }
        return null;
    }

}
