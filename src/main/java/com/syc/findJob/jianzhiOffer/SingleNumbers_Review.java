package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumbers_Review {

    /**
     * 异或运算，数组按位分组
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        int n = nums.length;
        //1. 计算异或结果
        for(int i = 0; i < n; ++i) {
            res ^= nums[i];
        }
        //2. 计算第几位为1
        int m = 1;
        while((res & m) == 0) {
            m <<= 1;
        }
        //3. 将数组根据异或结果分组，保证将两个结果数分到不同组中
        int a = 0, b = 0;
        for(int j = 0 ; j < n; ++j) {
            if((nums[j] & m) == 0) {
                a = a ^ nums[j];
            }else {
                b = b ^ nums[j];
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,5,3};
        System.out.println(Arrays.toString(new SingleNumbers_Review().singleNumbers(nums)));
    }
}
