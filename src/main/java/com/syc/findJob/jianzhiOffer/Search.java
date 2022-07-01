package com.syc.findJob.jianzhiOffer;

public class Search {
    public int search(int[] nums, int target) {

        return 0;

    }

    public int getFirstTarget(int[] nums, int target, int start, int end) {
        if(start < 0 || end >= nums.length) {
            return -1;
        }

        if(start == end && nums[start] == target) {
            return start;
        }

        if(start == end && nums[start] != target) {
            return -1;
        }

        int mid = (start + end) >> 1;

//        if(nums[mid] == target && nums[mid])

        return 0;

    }
}
