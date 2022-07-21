package com.syc.findJob.jianzhiOffer;

import java.util.*;

/**
 * 第一个只出现一次的字符
 */
public class FirstUniqChar {
    /**
     * hashmap+两次扫描
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if(null == s || s.length() == 0)
            return ' ';
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
        }

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if(map.get(c) == 1)
                return c;
        }
        return ' ';
    }

    /**
     * 使用队列+map，map中存储char的下标
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        LinkedList<MyChar> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        if(null == s || s.length() == 0)
            return ' ';
        int n = s.length();
        for(int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
                queue.addLast(new MyChar(c, i));
            }
            else {
                map.put(c, -1);
                while(!queue.isEmpty() && map.get(queue.getFirst().c) == -1) {
                    queue.removeFirst();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.getFirst().c;

    }

    class MyChar{
        char c;
        int pos;
        MyChar(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }


    /**
     * 第一个出现的字符，首尾下标相等
     * @param s
     * @return
     */
    public char firstUniqChar3(String s) {
        if(null == s || s.length() == 0)
            return ' ';
        int n = s.length();
        for(int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 使用数组（另一种形式的map），题目要求s中出现的字符都是小写字母
     * @param s
     * @return
     */
    public char firstUniqChar4(String s) {
        if(null == s || s.length() == 0)
            return ' ';
        int n = s.length();
        int[] arr = new int[26];
        for(int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            ++arr[c-'a'];
        }
        for(int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if(arr[c-'a'] == 1)
                return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        String str = "leetcode";
        char c = new FirstUniqChar().firstUniqChar4(str);
        System.out.println(c);
    }

}
