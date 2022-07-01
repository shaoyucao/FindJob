package com.syc.findJob.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Fib {

    int[] mem = new int[31];

    public int fib(int n) {

        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return fib(n-1) + fib(n-2);

    }


    //记忆化搜索，自上而下的解决问题
    public int fib2(int n) {

        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        if(mem[n] == 0) {
            mem[n] = fib(n-1) + fib(n-2);
        }

        return mem[n];

    }

    //动态规划，自下而上的解决问题
    public int fib3(int n) {
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2; i <= n; i++) {
            mem[i] = mem[i-2] + mem[i-1];
        }
        return mem[n];
    }

    //动态规划，自底向上解决，空间优化
    public int fib4(int n) {
        if(n < 2)
            return n;

        int fibone = 0;
        int fibtwo = 1;
        int fib = 0;
        for(int i = 2; i <= n; i++) {
            fib = (fibone + fibtwo) % 1000000007;
            fibone = fibtwo;
            fibtwo = fib;
        }
        return fib ;
    }

    public static void main(String[] args) {
        int n = 47;
        System.out.println(new Fib().fib4(n));
    }
}
