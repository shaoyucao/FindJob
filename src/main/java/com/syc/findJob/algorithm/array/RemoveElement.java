package com.syc.findJob.algorithm.array;

import java.util.Arrays;

public class RemoveElement {
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int k = new RemoveElement().removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }
}
