package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.Collections;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        if(null == nums)
            return 0;

        int len = nums.length;
        Arrays.sort(nums);

        return nums[len/2];

    }

    /**
     * 基于快速排序的查找算法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int mid = len / 2;
        int l = 0, r = len-1;
        int index = partition(nums, l, r);

        while(index != mid) {
            if(index <= mid) {
                l = index + 1;
                index = partition(nums, l, r);
            }else {
                r = index - 1;
                index = partition(nums, l, r);
            }
        }
        return nums[mid];
    }

    /**
     * 一次遍历，用数字出现的次数来考量是否是出现次数最多的那个元素
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;

        int ret = nums[0];
        int times = 1;

        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == ret)
                times++;
            else if(times == 0) {
                ret = nums[i];
                times = 1;
            }
            else
                times--;
        }
        return ret;
    }

    public int partition(int[] array, int l, int r) {
        int v = array[l];
        int i = l+1;
        int j = r;
        while(true) {
            while(i <= r && array[i] < v)
                i++;
            while(j >= l+1 && array[j] > v)
                j--;
            if(i > j)
                break;
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, l, j);
        return j;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int ret = new MajorityElement().majorityElement2(nums);
        System.out.println(ret);

    }
}
