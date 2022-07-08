package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 翻转单词顺序
 * 做这道题的关键是：在翻转之前需要去除字符串前后两端的空格，否则在翻转的过程中很难处理
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if(null == s)
            return null;
        s = s.trim();
        int n = s.length();
        int j = n-1, i = n-1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            while(j >= 0 && s.charAt(j) == ' ')
                --j;
            i = j;
            while(i >= 0 && s.charAt(i) != ' ')
                --i;
            sb.append(s.substring(i+1, j+1));
            j = i;
            if(i != -1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 考虑仅翻转字符串和单词的顺序
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        if(null == s)
            return null;
        StringBuilder sb = trimSpace(s);
        //1. 先反转字符串
        reverse(sb, 0, sb.length()-1);
        //2. 翻转字符串中单词的顺序
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder trimSpace(String str) {
        if(null == str)
            return null;
        int n = str.length();
        int i = 0, j = n-1;
        while(i <= j && str.charAt(i) == ' ') //循环的时候肯定必须要控制数组不能越界
            ++i;
        while(i <= j && str.charAt(j) == ' ')
            --j;
        StringBuilder sb = new StringBuilder();
        while(i <= j) {
            char c = str.charAt(i);
            if(c != ' ')
                sb.append(c);
            else if(sb.charAt(sb.length()-1) != ' ')//sb的最后一个不是空格的话，可以再附加空格
                sb.append(c);
            ++i;
        }
        return sb;
    }

    //翻转字符串，使用可变的数据结构StringBuilder
    public void reverse(StringBuilder sb, int l, int r) {
        while(l < r) {
            char c = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, c);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        if(null == sb)
            return;
        int n = sb.length();
        int start = 0, end = 0;
        while(end < n) {
            while(end < n && sb.charAt(end) != ' ')
                ++end;
            reverse(sb, start, end-1);
            start = end+1;
            end = start;
        }
    }

    public String reverseString(String s) {
        if(null == s)
            return null;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "  Hello  world  ";
        String res = new ReverseWords().reverseWords3(s);
        System.out.println(res);
        System.out.println(res.length());
    }

}
