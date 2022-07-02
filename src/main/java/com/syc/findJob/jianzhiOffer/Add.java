package com.syc.findJob.jianzhiOffer;

/**
 * 不用加减乘除做加法
 */
public class Add {
    public int add(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while(carry != 0);
        return sum;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int res = new Add().add(a, b);
        System.out.println(res);
    }
}
