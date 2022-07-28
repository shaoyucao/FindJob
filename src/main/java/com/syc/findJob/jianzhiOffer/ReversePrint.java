package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class ReversePrint {
    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * 使用双端队列
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if(null == head)
            return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        ListNode cur = head;
        while(null != cur) {
            list.offerFirst(cur.val);
            cur = cur.next;
        }
        int size = list.size();
        int[] res = new int[size];
        int i = 0;
        for(Integer x : list)
            res[i++] = x;
        return res;
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * 两次遍历
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        if(null == head)
            return new int[0];
        int count = 0;
        ListNode cur = head;
        while(null != cur) {
            ++count;
            cur = cur.next;
        }
        cur = head;
        int[] res = new int[count];
        while(null != cur) {
            res[--count] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    /**
     * 时间复杂度O(n), 空间复杂度O(n)
     * 递归
     * @param head
     * @return
     */
    public int[] reversePrint3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(null == head)
            return new int[0];
        ListNode cur = head;
        reverse(cur, list);
        int[] res = new int[list.size()];
        int i = 0;
        for(int x : list) {
            res[i++] = x;
        }
        return res;
    }

    public void reverse(ListNode cur, List<Integer> list) {
        if(null == cur)
            return;
        reverse(cur.next, list);
        list.add(cur.val);
    }

    /**
     * 时间复杂度O(n)， 空间复杂度O(n)
     * 栈
     * @param head
     * @return
     */
    public int[] reversePrint4(ListNode head) {
        if(null == head)
            return new int[0];
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(null != cur) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        int i = 0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }
}
