package com.syc.findJob.jianzhiOffer;

/**
 * 删除链表的节点
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {

        if(head == null)
            return null;

        if(head.val == val)
            return head.next;

        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return head;

    }

    /**
     * 定义虚拟头结点，用来解决删除的节点是头节点的情况
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if(null == head)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead, next = cur.next;
        while(null != next) {
            if(next.val == val) {
                cur.next = next.next;
                break;
            }
            else {
                cur = cur.next;
                next = next.next;
            }
        }
        return dummyHead.next;
    }
}
