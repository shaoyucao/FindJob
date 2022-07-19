package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

/**
 * 数组中数字只出现1次的两个数，（其他数字均出现了两次）
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        if(null == nums || nums.length < 2)
            return null;
        int n = nums.length;
        int ret = 0;
        //计算得到异或结果
        for(int i = 0; i < n; ++i) {
            ret ^= nums[i];
        }
        //从右往左数，第一位为1的位所在的位置
        int index = findFirstBitOf1(ret);
        int num1 = 0, num2 = 0;
        for(int i = 0; i < n; ++i) {
            if(indexIs1(nums[i], index)){
                num1 ^= nums[i];
            }
            else
                num2 ^= nums[i];
        }
        return new int[]{num1, num2};
    }

    public int findFirstBitOf1(int num) {
        int index = 0;
        while((num & 1) == 0 && index < 32) {
            num = num >> 1;
            ++index;
        }
        return index;
    }

    public boolean indexIs1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,2,5,5};
        int[] ret = new SingleNumbers().singleNumbers(nums);
        System.out.println(Arrays.toString(ret));
    }
}
