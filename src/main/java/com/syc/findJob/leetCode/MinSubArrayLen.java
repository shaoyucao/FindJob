package com.syc.findJob.leetCode;

public class MinSubArrayLen {
    //尝试暴力求解 O(n^2)
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum >= target){
                    res = Math.min(res, j-i+1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = -1; //nums[l...r]，滑动窗口初始没有元素
        int sum = 0;
        while(l < nums.length) {
            if(r+1 < nums.length && sum < target) {
                sum += nums[++r];
            }else{
                sum -= nums[l++];
            }
            if(sum >= target) {
                res = Math.min(res, r-l+1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;
        System.out.println(new MinSubArrayLen().minSubArrayLen2(target, nums));
    }
}
