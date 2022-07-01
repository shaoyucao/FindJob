package com.syc.findJob.jianzhiOffer;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        if(null == head)
            return null;

        ListNode cur = head, next = head.next;
        while(null != next) {
            if(cur.val == next.val){
                next = next.next;
                cur.next = next;
            }else{
                cur = cur.next;
                next = next.next;
            }
        }
        return head;

    }
}
