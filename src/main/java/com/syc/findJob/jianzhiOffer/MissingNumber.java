package com.syc.findJob.jianzhiOffer;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(null == nums || nums.length == 0)
            return -1;
        int n = nums.length;
        return getFirstUnMatchingNumber(nums, 0, n-1);
    }

    public int getFirstUnMatchingNumber(int[] nums, int l, int r) {
        if(l > r)
            return r+1;
        int mid = (l + r) >> 1;
        if(nums[mid] != mid) {
            if(mid > 0 && nums[mid-1] == mid -1 || mid == 0)
                return mid;
            else
                r = mid - 1;
        }
        else
            l = mid + 1;
        return getFirstUnMatchingNumber(nums, l, r);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int res = new MissingNumber().missingNumber(nums);
        System.out.println(res);
    }
}
