package com.syc.findJob.jianzhiOffer;

/**
 * 替换空格
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We are happy";
//        System.out.println(replaceSpace(str));
        System.out.println(replaceSpace3(str));
    }

    public static String replaceSpace(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String replaceSpace2(String str) {
        String rep = str.replace(" ", "%20");
        return rep;
    }

    public static String replaceSpace3(String str) {
        if(null == str)
            return null;
        int len = str.length();
        int newlen = 3 * len;
        char[] newStr = new char[newlen];
        int index = 0;
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == ' ') {
                newStr[index++] = '%';
                newStr[index++] = '2';
                newStr[index++] = '0';
            } else{
                newStr[index++] = str.charAt(i);
            }
        }

        return new String(newStr, 0, index);
    }

    ///////////  review

    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * 使用可变字符串StringBuilder
     * 或者使用Java中的内置函数str.replace(" ", "%20")，效果是一样的
     * @param str
     * @return
     */
    public static String replaceSpace2_1(String str) {
        if(null == str)
            return null;
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            char c = str.charAt(i);
            if(c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 时间复杂度O(n), 空间复杂度O(n)
     * 使用字符数组
     * @param str
     * @return
     */
    public static String replaceSpace2_2(String str) {
        if(null == str)
            return null;
        int n = str.length();
        char[] chars = new char[n*3];
        int index = 0;
        for(int i = 0; i < n; ++i) {
            char c = str.charAt(i);
            if(c == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            }
            else {
                chars[index++] = c;
            }
        }
        return new String(chars, 0, index);
    }
}
