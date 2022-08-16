package com.syc.findJob.jianzhiOffer;

public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1)
                ++count;
            n = n >>> 1;
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

    //review
    //题目没有说不能是负数
    public int hammingWeight4(int n) {
        int count = 0;
        for(int i = 0; i < 32; ++i) {
            if((n & 1) == 1) {
                ++count;
            }
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight5(int n) {
        int count = 0;
        while(n != 0) {
            count += (n & 1) == 1 ? 1 : 0;
            n >>>= 1;
        }
        return count;
    }

    /**
     * 寻找数字特征，每次将最右边的1变成0
     * @param n
     * @return
     */
    public int hammingWeight6(int n) {
        int count = 0;
        while(n != 0) {
            ++count;
            n &= (n-1);
        }
        return count;
    }
}
