package com.syc.findJob.leetCode;

public class ClimbStairs {
    //递归，超时
    public int climbStairs(int n) { // n属于[1...45]
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //动态规划
    public int climbStairs2(int n) {
        int[] mem = new int[n+1];
        mem[1] = 1;
        mem[2] = 2;
        for(int i = 3; i <= n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new ClimbStairs().climbStairs(n));
    }
}
