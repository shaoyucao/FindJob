package com.syc.findJob.test;

import java.util.Arrays;

/**
 * 跳跃游戏
 */
public class FeiZhuTest01 {

    //改进，有错误
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int count = 0, index = 0;
        int n = nums.length;
        while(index != n-1) {
            int step = nums[index];
            if(step == 0)
                return -1;
            if(index + step >= n-1) {
                ++count;
                break;
            }
            //maxStep当前位置往后跳，下一跳可以获得的最大跳跃步数；maxIndex 下一跳中的最大跳跃步数所在的索引
            int maxStep = 0, maxSubIndex = 0;
            for(int i = 0; i < step; ++i) {
                int subIndex = index+i+1;
                if(subIndex < n && nums[subIndex] >= maxStep) {
                    maxStep = nums[subIndex];
                    maxSubIndex = subIndex;
                }
            }
            count++;
            index = maxSubIndex+maxStep <= index+step ? index+step : maxSubIndex;
        }
        return count;

    }

    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    //动态规划解法，存在大量重复和无效的比较
    public int jump3(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                //能够跳到
                if(nums[j]+j >= i) {
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1];

    }

    //动态规划解法2，优化，但时间复杂度还是O(n^2)
    public int jump4(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i+1; j <= i+nums[i] && j < n; ++j) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }
        return dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1];
    }

    /**
     * 贪心算法，时间复杂度为O(n)，每次找能够跳的最远距离，作为边界；当遇到边界时，更新最远距离；
     * 这种方法比较抽象
     * @param nums
     * @return
     */
    public int jump5(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        for(int i = 0; i < n-1; ++i) {
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if(end == i) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }



    public static void main(String[] args) {
//        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        int[] nums = {2,3,1,1,4};
        System.out.println(new FeiZhuTest01().jump2(nums));
    }
}
