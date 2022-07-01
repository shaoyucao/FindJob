package com.syc.findJob.leetCode;

import com.syc.findJob.jianzhiOffer.ListNode;

public class ListNodeUtil {

    public static ListNode createLinkedList(int[] arr) {
        if(null == arr || arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,1,6,7};
        ListNode head = createLinkedList(arr);
        printLinkedList(head);
    }

}
