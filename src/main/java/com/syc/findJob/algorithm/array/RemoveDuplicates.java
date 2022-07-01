package com.syc.findJob.algorithm.array;

import java.util.Arrays;

public class RemoveDuplicates {
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1)
            return 1;
        int n = nums.length;
        int k = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }
}
