package com.syc.findJob.jianzhiOffer;

/**
 * 合并两个排序链表
 */
public class MergeTwoLists {
    /**
     * 迭代方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;
        ListNode c1 = l1, c2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while(null != c1 && null != c2) {
            if(c1.val >= c2.val) {
                cur.next = c2;
                c2 = c2.next;
            }
            else{
                cur.next = c1;
                c1 = c1.next;
            }
            cur = cur.next;
        }
        while(null != c1) {
            cur.next = c1;
            c1 = c1.next;
            cur = cur.next;
        }
        while(null != c2) {
            cur.next = c2;
            c2 = c2.next;
            cur = cur.next;
        }
        return dummyNode.next;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
