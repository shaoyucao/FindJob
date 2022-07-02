package com.syc.findJob.jianzhiOffer;

public class Search {

    /**
     * 时间复杂度为O(n),和正常的一次遍历相同，不推荐这种方法，看下面第二种
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0)
            return 0;
        int index = binarySearch(nums, target);
        if(index < 0)
            return 0;
        int count = 1;
        for(int i = index+1; i < nums.length; ++i) {
            if(nums[i] == target)
                ++count;
        }
        for(int i = index-1; i >= 0; --i) {
            if(nums[i] == target)
                ++count;
        }
        return count;
    }

    public int binarySearch(int[] nums, int target) {
        if(null == nums || nums.length == 0)
            return -1;
        int n = nums.length;
        return binarySearch(nums, target,0, n-1);
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        if(l > r)
            return -1;
        int mid = (l + r) >> 1;
        if(nums[mid] == target)
            return mid;
        if(target > nums[mid])
            return binarySearch(nums, target, mid+1, r);
        else return binarySearch(nums, target, l, mid-1);
    }

    public int search2(int[] nums, int target) {
        if(null == nums || nums.length == 0)
            return 0;
        int n = nums.length;
        int first = getFirstTarget(nums, target, 0, n-1);
        int end = getLastTarget(nums, target, 0, n-1);
        if(first != -1 && end != -1)
            return end - first + 1;
        return 0;
    }

    public int getFirstTarget(int[] nums, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        if(nums[mid] == target) {
            if(mid > 0 && nums[mid-1] != target || mid == 0)
                return mid;
            else
                end = mid-1;
        }
        else if(target > nums[mid])
            start = mid+1;
        else end = mid-1;
        return getFirstTarget(nums, target, start, end);
    }

    public int getLastTarget(int[] nums, int target, int start, int end) {
        if(start > end)
            return -1;
        int mid = (start + end) >> 1;
        if(nums[mid] == target) {
            if(mid < nums.length-1 && nums[mid+1] != target || mid == nums.length-1)
                return mid;
            else
                start = mid+1;
        }
        else if(target > nums[mid])
            start = mid+1;
        else
            end = mid-1;
        return getLastTarget(nums, target, start, end);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,3,6,6,8};
        int target = 6;
        int count = new Search().search2(nums, target);
        System.out.println(count);
    }
}
