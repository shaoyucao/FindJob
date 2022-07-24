package com.syc.findJob.jianzhiOffer;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(null == head)
            return null;
        ListNode meetingNode = findMeetingNode(head);
        if(null == meetingNode)
            return null;
        int circleNum = calCicleNum(meetingNode);
        ListNode fast = head, slow = head;
        while(circleNum > 0) {
            fast = fast.next;
            --circleNum;
        }
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 找相遇节点，快指针每次走两步，慢指针每次走一步；也可以快指针走三步，但没必要，反而会影响效率
     * @param head
     * @return
     */
    public ListNode findMeetingNode(ListNode head){
        ListNode fast = head, slow = head;
        while(null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return fast;
            }
        }
        return null;
    }

    public int calCicleNum(ListNode node) {
        int count = 1;
        ListNode cur = node.next;
        while(cur != node) {
            cur = cur.next;
            ++count;
        }
        return count;
    }
}
