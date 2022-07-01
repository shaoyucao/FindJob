package com.syc.findJob.leetCode;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s.equals(""))
            return true;
        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while(l <= r) {
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else if(l <= r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            else if(l <= r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new IsPalindrome().isPalindrome(s));
    }
}
