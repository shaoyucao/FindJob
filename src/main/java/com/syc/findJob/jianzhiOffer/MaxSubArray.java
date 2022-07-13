package com.syc.findJob.jianzhiOffer;

public class MaxSubArray {

    /**
     * 方法1：举例分析数组规律
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        int n = nums.length;
        int pre = nums[0];
        int ret = pre;
        for(int i = 1; i < n; ++i) {
            pre = (pre <= 0) ? nums[i] : (pre + nums[i]);
            ret = Math.max(ret, pre);
        }
        return ret;
    }

    /**
     * 方法2：动态规划思想，状态转移方程：
     *
     * f(i) = nums[i] (f(i-1) <= 0 || i == 0 )
     *      = f(i-1) + nums[i]
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ret = nums[0];
        for(int i = 1; i < n; ++i) {
            dp[i] = dp[i-1] <= 0 ? nums[i] : dp[i-1] + nums[i];
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
