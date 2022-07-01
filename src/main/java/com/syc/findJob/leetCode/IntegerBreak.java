package com.syc.findJob.leetCode;

public class IntegerBreak {
    public int integerBreak(int n) {
        if(n < 2) {
            return -1;
        }
        int[] mem = new int[n+1];
        return reBreak(n, mem);
    }

    private int findMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    //将n分割后可以获得的最大乘积
    //记忆化搜索
    private int reBreak(int n, int[] mem) {

        if(n == 1)
            return 1;

        if(mem[n] != 0) {
            return mem[n];
        }

        int res = -1;
        for(int i = 1; i < n; i++) {
            res = findMax(res, i * (n-i), i * reBreak(n-i, mem)); //比较当前值 i * (n-i) 以及 子结构 i *  拆分的(n-i)相乘的最大值
        }
        mem[n] =  res;

        return res;

    }

    public int integerBreak2(int n) {
        if(n < 2) {
            return -1;
        }

        int[] mem = new int[n+1];

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                mem[i] = findMax(mem[i], j * (i-j), j * mem[i-j]);
            }
        }

        return mem[n];

    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new IntegerBreak().integerBreak2(n));
    }
}
