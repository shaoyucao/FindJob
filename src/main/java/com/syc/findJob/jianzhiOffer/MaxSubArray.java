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

    ////review

    /**
     * 1. 如果之前和(或者说是当前和）小于0，则更新之前和（或者说当前和）为当前值，否则加上当前值
     * 2. 比较当前和和最大值，取较大值
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int cur = nums[0];
        int max = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; ++i) {
            if(cur < 0) {
                cur = nums[i];
            }
            else{
                cur += nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    /**
     * 动态规划解法，dp[i]表示以当前值为结尾可以获得的连续最大和
     * @param nums
     * @return
     */
    public int maxSubArray4(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; ++i) {
            dp[i] = (dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(new MaxSubArray().maxSubArray3(nums));
    }
}
