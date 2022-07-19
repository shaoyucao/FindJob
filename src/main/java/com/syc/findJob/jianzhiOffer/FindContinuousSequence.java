package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列，滑动窗口
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        if(target < 3)
            return null;
        int small = 1, big = 2;
        int mid = target >> 1;
        int sum = small + big;
        while(small <= mid) {
            if(sum < target) {
                ++big;
                sum += big;
            }
            else if(sum > target) {
                sum -= small;
                ++small;
            }
            else{
                int[] data = new int[big - small + 1];
                for(int i = small; i <= big; ++i) {
                    data[i-small] = i;
                }
                res.add(data);
                ++big;
                sum += big;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int target = 15;
        int[][] continuousSequence = new FindContinuousSequence().findContinuousSequence(target);
        System.out.println(Arrays.toString(continuousSequence));
    }
}
