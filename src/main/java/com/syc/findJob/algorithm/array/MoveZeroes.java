package com.syc.findJob.algorithm.array;

import java.util.Arrays;

public class MoveZeroes {

    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int n = nums.length;
        int[] arr = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                arr[count++] = nums[i];
            }
        }
        for(int i = 0; i < count; i++) {
            nums[i] = arr[i];
        }
        for(int i = count; i < n; i++) {
            nums[i] = 0;
        }
    }

    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int k = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[k++] = nums[i];  //保证在[0,k)的范围内都是非零元素
            }
        }

        for(int i = k; i < n; i++) {
            nums[i] = 0;
        }
    }

    //交换元素
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public void moveZeroes3(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int n = nums.length;
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                if(i != k)
                    swap(nums, k++, i);
                else
                    k++;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
