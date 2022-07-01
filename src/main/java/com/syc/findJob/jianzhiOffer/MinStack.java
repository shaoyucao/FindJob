package com.syc.findJob.jianzhiOffer;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> subStack;
    public MinStack() {
        stack = new Stack<Integer>();
        subStack = new Stack<Integer>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            subStack.push(x);
        }else {
            int top = subStack.peek();
            subStack.push(Math.min(x, top));
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        subStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if(stack.isEmpty())
            return Integer.MAX_VALUE;
        return subStack.peek();
    }
}
