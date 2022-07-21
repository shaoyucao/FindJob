package com.syc.findJob.jianzhiOffer;

/**
 * 计算第n个丑数（质因数只包含2，3，5的数）
 */
public class NthUglyNumber {
    /**
     * 动态规划，根据之前的dp，计算下一个dp。
     * 用三个变量分别对应数乘2，3，5，记录小于等于当前的最大值下标，下一次计算无需用之前的值再次计算。
     * 时间复杂度o(n), 空间复杂度o(n)
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n < 1)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0, three = 0, five = 0;
        for(int i = 1; i < n; ++i) {
            dp[i] = min(dp[two]*2, dp[three]*3, dp[five]*5);
            while(dp[two]*2 <= dp[i])
                ++two;
            while(dp[three]*3 <= dp[i])
                ++three;
            while(dp[five]*5 <= dp[i])
                ++five;
        }
        return dp[n-1];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12
        int n = 10;
        System.out.println(new NthUglyNumber().nthUglyNumber(n));
    }
}
