package com.syc.findJob.leetCode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if(t == null)
            return false;

        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }else {
                j++;
            }
        }

        return i == s.length();

    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s,t));
    }
}
