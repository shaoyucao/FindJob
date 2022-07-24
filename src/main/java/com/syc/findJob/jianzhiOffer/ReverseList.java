package com.syc.findJob.jianzhiOffer;

import org.springframework.expression.spel.ast.NullLiteral;

/**
 * 反转链表
 */
public class ReverseList {
    /**
     * 循环实现
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(null == head)
            return head;
        ListNode pre = null, cur = head;
        while(null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode newHead = reverseList2(head.next);
        newHead.next = head;
        head.next = null;
        return newHead;
    }
}
