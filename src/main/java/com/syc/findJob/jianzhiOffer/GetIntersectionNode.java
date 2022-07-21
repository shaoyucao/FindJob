package com.syc.findJob.jianzhiOffer;

import java.util.Stack;

public class GetIntersectionNode {
    /**
     * 使用两个辅助栈记录从后往前的相同的节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB)
            return null;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while(null != headA){
            stackA.push(headA);
            headA = headA.next;
        }
        while(null != headB) {
            stackB.push(headB);
            headB = headB.next;
        }
        //lastSameNode用来记录最后一个相同的节点，也即两个链表的第一个公共节点
        ListNode lastSameNode = null;
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode a = stackA.pop();
            ListNode b = stackB.pop();
            if(a == b)
                lastSameNode = a;
            else
                break;
        }
        return lastSameNode;
    }

    /**
     * 不用辅助栈，计算出两个链表的长度差，先在较长的链表上走几步，然后同时遍历
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(null == headA || null == headB)
            return null;
        int lenA = 0, lenB = 0;
        ListNode headOfA = headA, headOfB = headB;
        while(null != headA) {
            ++lenA;
            headA = headA.next;
        }
        while(null != headB) {
            ++lenB;
            headB = headB.next;
        }
        int offLen = lenA - lenB;
        if(offLen > 0) {
            while(offLen > 0) {
                headOfA = headOfA.next;
                --offLen;
            }
        }
        else {
            offLen = -offLen;
            while(offLen > 0) {
                headOfB = headOfB.next;
                --offLen;
            }
        }
        //headOfA == headOfB 时，要么两者为空，要么两者指向相同的节点
        while(headOfA != headOfB) {
            headOfA = headOfA.next;
            headOfB = headOfB.next;
        }
        return headOfA;
    }

    /**
     * 优化上一种方法的代码，以上代码写的比较丑陋
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(null == headA || null == headB)
            return null;
        ListNode longHead = headA, shortHead = headB;
        int lenA = getLenghOfListNode(headA);
        int lenB = getLenghOfListNode(headB);
        if(lenB > lenA) {
            longHead = headB;
            shortHead = headA;
        }
        int offLen = Math.abs(lenA-lenB);
        while(offLen > 0) {
            longHead = longHead.next;
            --offLen;
        }
        while(longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    public int getLenghOfListNode(ListNode head) {
        if(null == head)
            return 0;
        int length = 0;
        while(null != head) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
