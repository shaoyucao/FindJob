package com.syc.findJob.jianzhiOffer;

public class MyPow {
    public boolean isInvalidInput;
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        long N = n; //需要考虑n = -2147483648时，取负数越界，因此需要使用long类型
        if(x == 0 && N < 0) {
            isInvalidInput = true;
            return 0;
        }
        return (N < 0 ? 1 / power(x, -N) : power(x, N));
    }

    public double power(double x, long n) {
        if(n == 1)
            return x;
        double res;
        res = power(x, n >> 1);
        res *= res;
        if((n & 1) == 1)
            res *= x;
        return res;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -3;
        System.out.println(new MyPow().myPow(x, n));
    }
}
