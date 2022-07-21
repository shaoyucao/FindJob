package com.syc.findJob.jianzhiOffer;

/**
 * 数组中的逆序对
 */
public class ReversePairs {
    /**
     * 纯暴力解法，超时
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        int count = 0, n = nums.length;
        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                if(nums[i] > nums[j])
                    ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println(new ReversePairs().reversePairs(nums));
    }
}
