package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

/**
 * 构建乘积数组
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        if(null == a)
            return null;
        if(a.length == 0)
            return new int[0];

        int n = a.length;
        int[] res = new int[n];

        //考虑如果数组只有一个数，要怎么解？
        //--> 除去该元素后，乘积为1

        res[0] = 1;
        for(int i = 1; i < n; ++i) {
            res[i] = res[i-1] * a[i-1];
        }

        int r = 1;
        for(int i = n-1; i >= 0; --i) {
            res[i] = res[i] * r;
            r *= a[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {2};
        int[] res = new ConstructArr().constructArr(a);
        System.out.println(Arrays.toString(res));
    }
}
