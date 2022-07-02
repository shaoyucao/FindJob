package com.syc.findJob.jianzhiOffer;

/**
 * 第六章，第三题，数组中数值和下标相等的元素
 */
public class ValueMatchingIndexNum {

    public int valueMatchingIndexNum(int[] nums) {
        if(null == nums || nums.length == 0)
            return -1;
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r) {
            //取中间的数，为了避免著名的大数越界问题，最好改为以下写法：
            int mid = l + ((r - l) >> 1);
//            int mid = (l + r) >> 1;
            if(nums[mid] == mid)
                return mid;
            else if(nums[mid] > mid)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 2, 5};
        int res = new ValueMatchingIndexNum().valueMatchingIndexNum(nums);
        System.out.println(res);
    }
}
