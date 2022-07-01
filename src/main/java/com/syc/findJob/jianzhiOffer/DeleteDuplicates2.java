package com.syc.findJob.jianzhiOffer;

import com.syc.findJob.leetCode.ListNodeUtil;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {

        if(null == head){
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead, cur = head, next = cur.next;
        while(null != next) {
            if(cur.val != next.val) {
                next = next.next;
                cur = cur.next;
                pre = pre.next;
            }else {
                while(next != null && cur.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
                cur = next;
                if(next != null){
                    next = next.next;
                }
            }

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode linkedList = ListNodeUtil.createLinkedList(new int[]{1, 1, 2});
        ListNode listNode = new DeleteDuplicates2().deleteDuplicates(linkedList);
        ListNodeUtil.printLinkedList(listNode);
    }
}
