package com.syc.findJob.jianzhiOffer;

/**
 * 最小路径和
 * 矩阵从左上角到右下角的最小路径和
 * 空间复杂度O(n^2)
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; ++i) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; ++i) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 开辟一维辅助数组，进行空间上的优化
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        //初始化第一行
        dp[0] = grid[0][0];
        for(int i = 1; i < n; ++i) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        for(int i = 1; i < m; ++i) {
            //初始化第一列
            dp[0] += grid[i][0];
            for(int j = 1; j < n; ++j) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[n-1];
    }

    /**
     * 动态规划，在原数组上操作
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1; i < n; ++i) {
            grid[0][i] += grid[0][i-1];
        }

        for(int i = 1; i < m; ++i) {
            grid[i][0] += grid[i-1][0];
        }

        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }


}
