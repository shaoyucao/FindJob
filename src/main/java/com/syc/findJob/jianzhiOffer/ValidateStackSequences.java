package com.syc.findJob.jianzhiOffer;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) { //以入栈元素为基准，元素需要全部入栈
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,0};
        int[] popped = {1,0};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }
}
