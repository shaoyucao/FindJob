package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(null == nums)
            return null;
        int i = 0, j = nums.length-1;
        while(i < j) {
            int x = nums[i], y = nums[j];
            int sum = x + y;
            if(sum == target)
                return new int[]{x, y};
            else if(sum < target)
                ++i;
            else --j;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,11,15};
        int target = 15;
        int[] res = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
