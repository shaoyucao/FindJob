package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords_Review {

    public String reverseWords(String s) {
        if(s == null)
            return null;
        s = removeStartBlank(s);
        s = removeEndBlank(s);
        return reverse(s);
    }

    public String removeStartBlank(String s) {
        int i = 0 ;
        int len = s.length();
        for( ; i < len; ++i) {
            if(s.charAt(i) != ' ') {
                break;
            }
        }
        return s.substring(i, len);
    }

    public String removeEndBlank(String s) {
        int i = s.length() - 1;
        while(i >= 0) {
            if(s.charAt(i) != ' ') {
                break;
            }
            i--;
        }
        return s.substring(0, i+1);
    }

    public String reverse(String s) {
        List<String> list = new ArrayList<>();
        int i = 0, j = 0, len = s.length();
        while(j < len) {
            while(j < len && s.charAt(j) != ' ') {
                ++j;
            }
            list.add(s.substring(i,j));
            while(j < len && s.charAt(j) == ' ') {
                ++j;
            }
            i = j;
        }

        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for(int k = n - 1; k > 0; --k) {
            sb.append(list.get(k));
            sb.append(" ");
        }
        if(n > 0) {
            sb.append(list.get(0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "  ab  d cc";
        ReverseWords_Review reverseWords_review = new ReverseWords_Review();
        String s = reverseWords_review.reverseWords(a);
        System.out.println(s);
    }
}
