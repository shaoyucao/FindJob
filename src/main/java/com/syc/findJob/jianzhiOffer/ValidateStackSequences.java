package com.syc.findJob.jianzhiOffer;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if(null == pushed || null == popped || pushed.length != popped.length)
            return false;
        if(pushed.length == 0)
            return true;
        int i = 0, j = 0;
        int n = pushed.length;
        while(i < n) {
            //入队
            stack.push(pushed[i++]);

            //出队
            while(!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }
}
