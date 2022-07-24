package com.syc.findJob.jianzhiOffer;

/**
 * 表示数值的字符串
 */
public class IsNumber {
    int index = 0;
    boolean integerContainSpace = false;
    public boolean isNumber(String s) {
        if(null == s || s.length() == 0)
            return false;
        int n = s.length();
        boolean ret = scanInteger(s, index, n);
        if(index < n) {
            if(s.charAt(index) == ' ')
                return false;
            if(s.charAt(index) == '.') {
                ++index;
                //下面为什么用||的原因：
                //1. 小数可以没有整数部分；如： .23
                //2. 小数可以没有小数部分；如：2.
                ret = ret || scanFloatUnsignedInteger(s, index, n);
            }
            if(index < n && s.charAt(index) == ' ')
                return false;
            if(index < n && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
                ++index;
                //下面为什么用&&的原因：
                //1. 指数前必须有数字，如e3不构成数值
                //2. 指数部分必须有数字，如3.2e不构成数值
                ret = ret && scanInteger(s, index, n);
            }
        }
        return ret;
    }

    public boolean scanUnsignedInteger(String s, int index, int n) {
        int count = 0;
        while(index < n && s.charAt(index) == ' ') {
            ++index;
        }
        while(index < n && Character.isDigit(s.charAt(index))) {
            ++count;
            ++index;
        }
        this.index = index;
        return count > 0;
    }

    public boolean scanFloatUnsignedInteger(String s, int index, int n) {
        int preIndex = index;
        while(index < n && Character.isDigit(s.charAt(index)))
            ++index;
        this.index = index;
        return index > preIndex;
    }

    public boolean scanInteger(String s, int index, int n) {
        if(index < n && (s.charAt(index) == '+' || s.charAt(index) == '-'))
            ++index;
        return scanUnsignedInteger(s, index, n);
    }


    public static void main(String[] args) {
        String s = ".34e5";
        System.out.println(new IsNumber().isNumber(s));

        String s2 = "1 ";
        System.out.println(new IsNumber().isNumber(s2));
    }
}
