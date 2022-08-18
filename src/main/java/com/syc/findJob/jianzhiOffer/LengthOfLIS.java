package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LengthOfLIS {
    //动态规划，时间复杂度O(n^2)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                dp[i] = nums[i] > nums[j] ? Math.max(dp[i], dp[j]+1) : dp[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 贪心+二分查找
     * 维护一个数组d, 表示长度为len的数组的末尾元素的最小值；
     * 在遍历过程中如果后面的元素比最小值还大，则直接加到数组末尾，长度加1
     * 否则，更新前面的元素，找到比他大的元素
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] d = new int[n];
        d[0] = nums[0];
        int len = 1;

        for(int i = 1; i < n; ++i) {
            if(nums[i] > d[len-1]) {
                d[len] = nums[i];
                ++len;
            }
            else if(nums[i] < d[len-1]) {
                int pos = findFirstLessNumIndex(d, 0, len-1, nums[i]);
                d[pos+1] = nums[i];
            }
        }
        return len;
    }

    public int findFirstLessNumIndex(int[] nums, int l, int r, int num) {
        int pos = -1;
        while(l <= r) {
            int mid = (l+r) >> 1;
            if(nums[mid] < num) {
                pos = mid;
                l = mid + 1;
            }
            else {
                r = mid-1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LengthOfLIS().lengthOfLIS2(nums));
    }

}
