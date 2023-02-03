package com.syc.findJob.jianzhiOffer;

public class TwoSum_Review {
    public int[] twoSum(int[] nums, int target)  {
        //边界考虑:
        if(nums == null || nums.length < 2) {
            return new int[2];
        }
        int n = nums.length;
        int i = 0, j = n - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                break;
            }
            else if(sum < target) {
                i++;
            }
            else j--;
        }
        return new int[]{nums[i], nums[j]};
    }
}
