package com.syc.findJob.leetCode;

import com.syc.findJob.jianzhiOffer.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start, end;
        int index = 1;
        ListNode temp = head;
        while(index < left) {
            temp = temp.next;
            index++;
        }
        start = temp;

        while(index <= right) {
            temp = temp.next;
            index++;
        }
        end = temp;

        return null;


    }
}
