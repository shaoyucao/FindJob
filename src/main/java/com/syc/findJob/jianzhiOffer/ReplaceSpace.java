package com.syc.findJob.jianzhiOffer;

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
}
