package com.syc.findJob.jianzhiOffer;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA, curA = headA;
        ListNode b = headB, curB = headB;

        if(null == headA || null == headB)
            return null;

        while(a.next != null) {
            a = a.next;
        }
        a.next = headB;

        while(b.next != null) {
            b = b.next;
        }
        b.next = headA;

        while(curA != curB && curA.next != null) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while(curA != curB) {
            if(null == curA.next)
                curA.next = headB;
            if(null == curB.next)
                curB.next = headA;
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
