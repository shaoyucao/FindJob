package com.syc.findJob.leetCode;

public class Rob {

    //递归方法，记忆化搜索
    public int rob(int[] nums) {

        int[] mem = new int[nums.length+1];

        return tryRob(nums, 0, mem);

    }

    //考虑抢劫[index...n-1]范围的房子
    public int tryRob(int[] nums, int index, int[] mem) {

        if(index >= nums.length) {
            return 0;
        }

        if(mem[index] != 0) {
            return mem[index];
        }
        int res = 0;
        for(int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i+2, mem));
        }
        mem[index] = res;

        return res;

    }

    public int rob2(int[] nums) {

        int n = nums.length;

        //dp[i]表示从nums[i...n-1]的房子中偷窃能够获得的最大值
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                dp[i] = Math.max(dp[i], nums[j] + ( j+2>=n ? 0 : dp[j+2]));
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,4};
        System.out.println(new Rob().rob2(nums));
    }

}
