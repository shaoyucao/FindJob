package com.syc.findJob.jianzhiOffer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 时间复杂度O(1)，空间复杂度O(1)
 */
public class CQueue {

    Stack<Integer> s1, s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()) {
            if(s1.isEmpty()) {
                return -1;
            }
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
