package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 思路：三步走
 * 1.数组排序
 * 2.计算数组中0的个数
 * 3.计算数组中空缺数
 * 最后比较空缺数和0的数量的大小
 */
public class IsStraight {

    //自己的算法。效率超27%，判断上面花较多时间
    public boolean isStraight(int[] nums) {
        if(null == nums || nums.length  < 1)
            return false;

        Arrays.sort(nums);

        int zeroCount = 0, gapNum = 0;
        int n = nums.length;

        for(int i = 0; i < n; ++i) {
            if(nums[i] == 0)
                ++zeroCount;
            if(i < n-1 && nums[i] != 0 && nums[i]+1 != nums[i+1]) {
                gapNum += nums[i+1] - nums[i] - 1; //这里的gap数量不用先判断再计算，可以直接用公式计算出来。
            }
            if(i < n-1 && nums[i] != 0 && nums[i] == nums[i+1])
                return false;
        }

        if(gapNum > zeroCount)
            return false;

        return true;
    }

    //官方写法复现，超100%，很值得学习，节省了很多无用判断。
    public boolean isStraight2(int[] nums) {
        if(null == nums || nums.length  < 1)
            return false;

        Arrays.sort(nums);

        int numberOfZero = 0, numberOfGap = 0;
        int n = nums.length;

        for(int i = 0; i < n; ++i) {
            if(nums[i] == 0)
                ++numberOfZero;
        }

        int l = numberOfZero;
        int r = l + 1;
        while(r < n) {
            if(nums[l] == nums[r])
                return false;
            numberOfGap += nums[r] - nums[l] - 1;
            l = r;
            ++r;
        }

        return numberOfGap <= numberOfZero;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,6};
        boolean straight = new IsStraight().isStraight2(nums);
        System.out.println(straight);

    }
}
