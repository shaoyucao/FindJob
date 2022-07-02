package com.syc.findJob.jianzhiOffer;

/**
 * 面试题64，不用乘除法等 实现加法运算
 */
public class SumNums {

    //逻辑与运算+递归方法
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(--n)) > 0;
        return n;
    }
}
