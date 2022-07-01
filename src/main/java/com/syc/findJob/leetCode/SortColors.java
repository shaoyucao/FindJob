package com.syc.findJob.leetCode;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        if(null == nums || nums.length == 0)
            return;
        int n = nums.length;
        sortColors(nums, 0, n-1);

    }

    public void sortColors(int[] nums, int l, int r) {

        int zero = -1;
        int two = r+1;

        for(int i = 0; i < two; ) {
            if(nums[i] == 0) {
                swap(nums, ++zero, i++);
            }
            else if(nums[i] == 1) {
                i++;
            }
            else if(nums[i] == 2) {
                swap(nums, --two, i);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1, 2,0,1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
