package com.syc.findJob.jianzhiOffer;

import java.util.List;

/**
 * 三角形最小路径和
 */
public class MinimumTotal {
    //错误的思路
    public int minimumTotal(List<List<Integer>> triangle) {
        if(null == triangle || triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        int index = 0;
        for(int depth = 1; depth < size; ++depth) {
            List<Integer> level = triangle.get(depth);
            index = level.get(index) < level.get(index+1) ? index : index+1;
            dp[depth] = dp[depth-1] + level.get(index);
        }
        return dp[size-1];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if(null == triangle || triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j <= i; ++j) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int ret = dp[n-1][0];
        for(int i = 0; i < n; ++i) {
            ret = Math.min(ret, dp[n-1][i]);
        }
        return ret;
    }

}
