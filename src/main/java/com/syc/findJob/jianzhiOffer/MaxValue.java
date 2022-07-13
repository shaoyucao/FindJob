package com.syc.findJob.jianzhiOffer;

public class MaxValue {
    public int maxValue(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        //dp初始化
        dp[0][0] = grid[0][0];
        for(int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; ++i) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //遍历计算
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grids = {{1,3,1},{1,5,1},{4,2,1}};
        int ret = new MaxValue().maxValue(grids);
        System.out.println(ret);
    }
}
