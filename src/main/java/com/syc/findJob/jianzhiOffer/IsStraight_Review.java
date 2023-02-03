package com.syc.findJob.jianzhiOffer;

public class IsStraight_Review {
    public boolean isStraight(int[] nums) {
        int zero = 0, min = 1, max = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == 0) {
                zero++;
            }
            if(nums[i] != 0) {
                min = Math.min(nums[i], min);
            }
            max = Math.max(nums[i], max);
        }
        if(zero == 5)
            return true;
        if(max > min + 4 || max < min + 6 - zero) {
            return false;
        }
        return true;
    }
}
