package com.syc.findJob.jianzhiOffer;

public class GetNextNode {
    public TreeLinkNode getNextNode(TreeLinkNode treeNode) {

        if(treeNode == null)
            return null;

        //有右孩子
        if(treeNode.right != null) {
            treeNode = treeNode.right;
            while(treeNode.left != null)
                treeNode = treeNode.left;
            return treeNode;
        }

        //没有右孩子（1）如果该节点为父节点的左节点，则返回父节点；（2）不过不是父节点的左孩子，则一直向上找，直到找到一个节点为父节点的左节点
        while(treeNode.next != null) {
            if(treeNode.next.left == treeNode) {
                return treeNode.next;
            }
            treeNode = treeNode.next;
        }

        //如果是最后一个节点，则返回下一个节点为空
        return null;



    }




}
