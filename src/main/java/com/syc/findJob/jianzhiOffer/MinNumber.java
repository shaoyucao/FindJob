package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class MinNumber {
    /**
     * 方法1：使用内置的字符串排序，重写compareTo方法
     * 方法2：使用自定义的函数，重写快排
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if(null == nums || nums.length == 0)
            return null;
        int n = nums.length;
        String[] strs = new String[n];
        for(int i = 0; i < n; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x+y).compareTo(y+x)); //x+y 小于 y+x
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {30, 3, 312};
        MinNumber minNumber = new MinNumber();
        String str = minNumber.minNumber(nums);
        System.out.println(str);
    }
}
