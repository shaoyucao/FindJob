package com.syc.findJob.leetCode;

//0-1背包问题,记忆化搜索
public class Knapsack {
    public int knapsack(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] memo = new int[n][C+1];
        return bestValue(w, v, n-1, C, memo);
    }

    //计算[0...index]，背包容量为c，所能存放的最大价值
    private int bestValue(int[] w, int[] v, int index, int c, int[][] memo) {
        if(index < 0 || c <= 0)
            return 0;
        if(memo[index][c] != 0) {
            return memo[index][c];
        }
        int res = bestValue(w, v, index-1, c, memo); //不放第i个物品
        if(w[index] <= c) {
            res = Math.max(res, v[index] + bestValue(w, v, index-1, c-w[index], memo));
        }
        memo[index][c] = res;
        return res;
    }

    //动态规划
    private int bestValue2(int[] w, int[] v, int index, int c) {

        int n = w.length;
        if(n == 0)
            return 0;

        int[][] memo = new int[n][c+1];

        for(int j = 0; j <= c; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0); //初始化第一行
        }

        for(int i = 1; i <n; i++) {
            for(int j = 0; j <= c; j++) {
                memo[i][j] = memo[i-1][j];
                if(j >= w[j]) {
                    memo[i][j] = Math.max(memo[i][j], v[i]+memo[i-1][j-w[i]]);
                }
            }
        }
        return memo[n-1][c];

    }

    //动态规划, 空间优化1
    private int bestValue3(int[] w, int[] v, int index, int c) {

        int n = w.length;
        if(n == 0)
            return 0;

        int[][] memo = new int[2][c+1];

        for(int j = 0; j <= c; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0); //初始化第一行，无需改动
        }

        for(int i = 1; i <n; i++) {
            for(int j = 0; j <= c; j++) {
                memo[i%2][j] = memo[(i-1)%2][j];
                if(j >= w[j]) {
                    memo[i%2][j] = Math.max(memo[i%2][j], v[i]+memo[(i-1)%2][j-w[i]]);
                }
            }
        }
        return memo[(n-1)%2][c];

    }

    //动态规划, 空间优化2, O（c）, 时间复杂度O(n^2) 时间也优化了一些
    private int bestValue4(int[] w, int[] v, int index, int c) {

        int n = w.length;
        if(n == 0)
            return 0;

        int[] memo = new int[c+1];

        for(int j = 0; j <= c; j++) {
            memo[j] = (j >= w[0] ? v[0] : 0); //初始化第一行，无需改动
        }

        for(int i = 1; i <n; i++) {
            for(int j = n; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i]+memo[j-w[i]]);
            }
        }
        return memo[c];

    }


    public static void main(String[] args) {
        int[] w = new int[]{1,2,3};
        int[] v = new int[]{6,10,12};
        int C = 5;
        int n = w.length;
        System.out.println(new Knapsack().knapsack(w,v,C));
    }
}
