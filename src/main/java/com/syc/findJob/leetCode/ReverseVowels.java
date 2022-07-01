package com.syc.findJob.leetCode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        if(null == s || s.equals(""))
            return s;
        int l = 0, r = s.length()-1;
        while(l < r) {
            while(l < r && !isVowel(s.charAt(l))) {
                l++;
            }
            while(l < r && !isVowel(s.charAt(r))) {
                r--;
            }
            swap(chars, l++, r--);
        }

        return new String(chars);

    }

    public boolean isVowel(char c) {
        String str = "aeiouAEIOU";
        return str.indexOf(c) >= 0;
    }

    public void swap(char[] chars, int l, int r) {
        char c = chars[r];
        chars[r] = chars[l];
        chars[l] = c;
    }

    public static void main(String[] args) {
        String str = "saedu";
        String s = new ReverseVowels().reverseVowels(str);
        System.out.println(s);
    }
}
