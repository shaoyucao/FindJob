package com.syc.findJob.jianzhiOffer;

public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if(n < 2)
            return 0;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;

        int timesOf3 = n / 3;

        if(n - 3*timesOf3 == 1){
            timesOf3-=1;
        }

        int timesOf2 = (n - 3 * timesOf3) / 2;

        return (int)Math.pow(3,timesOf3) * (int)Math.pow(2, timesOf2);

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new CuttingRope().cuttingRope2(n));
    }

    ///review

    /**
     * 动态规划，时间复杂度O(n^2), 空间复杂度O(n)
     * @param n
     * @return
     */
    public int cuttingRope3(int n) {
        if(n < 2)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 1; j <= i / 2; j++) {
                dp[i] = max(dp[i], j * (i-j), j * dp[i-j]);
            }
        }
        return dp[n];
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }
}
