package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class Exchange {
    /**
     * 收尾双指针方法
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if(null == nums)
            return null;
        if(nums.length == 0)
            return new int[0];
        int n = nums.length;
        int i = 0, j = n - 1;
        while(true) {
            while(i < n && isSingle(nums[i]))
                ++i;
            while(j >= 0 && !isSingle(nums[j]))
                --j;
            if(i > j)
                break;
            swap(nums, i, j);
            ++i;
            --j;
        }
        return nums;
    }

    /**
     * 快慢双指针方法
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        if(null == nums)
            return null;
        if(nums.length == 0)
            return new int[0];
        int n = nums.length;
        int j = 0, i = 0;
        while(i < n) {
            if(isSingle(nums[i])) {
                swap(nums, j++, i);
            }
            i++;
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public boolean isSingle(int num) {
        return (num & 1) != 0;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new Exchange().exchange2(nums)));
    }
}
