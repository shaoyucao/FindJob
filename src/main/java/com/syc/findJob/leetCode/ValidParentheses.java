package com.syc.findJob.leetCode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            else if(map.containsValue(s.charAt(i))) {
                if(stack.isEmpty() || !map.get(stack.pop()).equals(s.charAt(i))) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(5);

        String a = "a";
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4};
        int[] b = new int[]{7,3,4,5};
        System.out.println(Arrays.equals(a, b));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
    }
}
