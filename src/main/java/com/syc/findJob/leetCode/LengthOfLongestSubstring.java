package com.syc.findJob.leetCode;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1;
        int res = 0;
        char[] chars = new char[256];
        while(l < s.length()) {
            if(r+1 < s.length() && chars[s.charAt(r+1)] == 0) {
                chars[s.charAt(++r)]++;
            }else {
                chars[s.charAt(l++)]--;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(str));
    }
}
