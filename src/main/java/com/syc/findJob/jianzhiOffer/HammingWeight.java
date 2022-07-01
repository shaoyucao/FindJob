package com.syc.findJob.jianzhiOffer;

public class HammingWeight {
    //如果n是负数，会引起死循环
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1)
                ++count;
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++)
            if((n & (1 << i)) != 0) {
                ++count;
            }
        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        while(n != 0) {
            ++count;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new HammingWeight().hammingWeight(n));
    }
}
