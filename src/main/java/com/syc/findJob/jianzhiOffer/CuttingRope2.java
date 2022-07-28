package com.syc.findJob.jianzhiOffer;

/**
 * 剪绳子II
 */
public class CuttingRope2 {
    public int cuttingRope(int n) {
        if(n <= 1)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= n; ++i) { //算每一个数值
            for(int j = 1; j < i; ++j) { //每个数值的计算方式
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

        return (int)(Math.pow(3,timesOf3) * Math.pow(2, timesOf2) % 1000000007);

    }

    public static void main(String[] args) {
        int n = 120;
        System.out.println(new CuttingRope2().cuttingRope2(n));
    }
}
