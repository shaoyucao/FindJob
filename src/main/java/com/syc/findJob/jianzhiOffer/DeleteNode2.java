package com.syc.findJob.jianzhiOffer;

/**
 * 删除链表的节点
 */
public class DeleteNode2 {
    public void deleteNode(ListNode node) {
        if(null == node)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
