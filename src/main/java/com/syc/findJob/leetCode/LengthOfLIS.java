package com.syc.findJob.leetCode;

import java.util.Arrays;

public class LengthOfLIS {
    // nums = {10,9,2,5,3,7,101,18}, 最长上升子序列 2,3,7,101
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;

    }

    public static void main(String[] args) {

        int[] dp = new int[5];

        System.out.println(dp[1]);

    }


}
