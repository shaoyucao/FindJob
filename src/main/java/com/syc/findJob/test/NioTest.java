package com.syc.findJob.test;

import java.util.HashMap;

public class NioTest {

    public int lengthOfLongestSubstring(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int n = str.length();
        int i = 0, j = 1;
        int maxLength = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);
        for( ; j < n; ++j) {
            char c = str.charAt(j);
            if(map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            maxLength = Math.max(maxLength, j-i+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(new NioTest().lengthOfLongestSubstring(str));
    }
}
