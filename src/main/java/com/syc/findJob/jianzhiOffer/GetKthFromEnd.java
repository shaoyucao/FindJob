package com.syc.findJob.jianzhiOffer;

/**
 * 链表中的倒数第k个节点
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(null == head)
            return null;
        ListNode fast = head, slow = head;
        while(k > 0) {
            fast = fast.next;
            --k;
        }
        while(null != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
