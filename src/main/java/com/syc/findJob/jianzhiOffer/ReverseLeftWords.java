package com.syc.findJob.jianzhiOffer;

/**
 * Java中可以通过字符拼接解决问题
 * 书上的思路是：先翻转前后两个小的字符串，然后再翻转整个字符串
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if(null == s)
            return null;
        String left = s.substring(0, n);
        String right = s.substring(n, s.length());
        return right+left;
    }

    public static void main(String[] args) {
        String str = "Hello";
        String res = new ReverseLeftWords().reverseLeftWords(str, 2);
        System.out.println(res);
    }
}
