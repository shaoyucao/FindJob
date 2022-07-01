package com.syc.findJob.jianzhiOffer;

public class MyTestApp {

    public static void main(String[] args) {

        MyTestApp t = new MyTestApp();
        System.out.println(t.test1_calculateSumN(100));

    }

    public int test1_calculateSumN(int n ) {
        if(n == 0)
            return 0;
        return n + test1_calculateSumN(n-1);
    }
}
