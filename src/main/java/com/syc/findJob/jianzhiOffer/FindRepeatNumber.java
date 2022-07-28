package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 */
public class FindRepeatNumber {
    //2, 3, 1, 0, 2, 5, 3 , 返回2 或者 3
    /**
     * 时间O(n), 空间O(n)
     * 辅助set
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if(null == nums)
            return -1;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else
                return nums[i];
        }
        return 0;
    }

    /**
     * 时间O(nlogn)， 空间O(1)
     * 排序+一次遍历
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        if(null == nums)
            return -1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; ++i) {
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return 0;
    }

    /**
     * 时间O(n^2)，空间O(1)
     * 暴力遍历
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        if(null == nums)
            return -1;
        int n = nums.length;
        for(int i = 0; i < n - 1; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    /**
     * 时间O(n)，空间O(1)， 【最快】
     * 利用数组中元素的特征，将数组中的值和下标对应
     * @param nums
     * @return
     */
    public int findRepeatNumber4(int[] nums) {
        if(null == nums)
            return -1;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] != i) {
                if(nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int a = nums[j];
        nums[j] = nums[i];
        nums[i] = a;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 3};
        System.out.println(new FindRepeatNumber().findRepeatNumber4(nums));
    }
}
