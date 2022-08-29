package com.syc.findJob.test;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class BytedanceTest {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newHead = reverse(node1);
        ListNode cur = newHead;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

    public static ListNode reverse(ListNode head) {
        if(null == head || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        ListNode newHead = fast;
        ListNode pre = null;
        while(fast != null) {
            if(pre != null) {
                pre.next = fast;
            }
            ListNode temp = fast.next;
            fast.next = slow;
            slow.next = temp;
            pre = slow;
            slow = temp;
            if(temp == null) {
                break;
            }
            fast = slow.next;
        }
        return newHead;
    }
}
