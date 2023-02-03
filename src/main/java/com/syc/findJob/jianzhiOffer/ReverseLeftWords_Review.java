package com.syc.findJob.jianzhiOffer;

public class ReverseLeftWords_Review {

    /**
     * 简单截取
     */
    public String reverseLeftWords(String s, int n) {
        if(s == null)
            return null;
        int len = s.length();
        //长度判断
        if(n >= len)
            return s;
        String sub1 = s.substring(0, n);
        String sub2 = s.substring(n, len);
        return sub2 + sub1;
    }

    /**
     * 简单拼接
     */
    public String reverseLeftWords2(String s, int n) {
        if(s == null)
            return null;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < len; ++i) {
            sb.append(s.charAt(i));
        }
        for(int i = 0; i < n; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
