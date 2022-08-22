package com.syc.findJob.jianzhiOffer;

public class Search {


    /**
     * 暴力解法
     * 时间复杂度O(n), 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for(int num : nums) {
            count += num == target ? 1 : 0;
        }
        return count;
    }

    /**
     * 二分查找+遍历
     * @param nums
     * @param target
     * @return
     */
    public int search02(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int index = binarySearch2(nums, target);
        if(index == -1)
            return 0;

        int firstIndex = getFirst(nums, index, target);
        int lastIndex = getLast(nums, index, target);
        return lastIndex - firstIndex - 1;
    }

    public int binarySearch2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public int getFirst(int[] nums, int index, int target) {
        int i = index;
        while(i >= 0 && nums[i] == target) {
            --i;
        }
        return i;
    }

    public int getLast(int[] nums, int index, int target) {
        int i = index;
        while(i< nums.length && nums[i] == target) {
            ++i;
        }
        return i;
    }

    /**
     * 二分查找优化
     * @param nums
     * @param target
     * @return
     */
    public int search03(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;

        int firstTargetIndex = getFirstTarget(nums, target);
        if(firstTargetIndex == -1)
            return 0;
        int lastTargetIndex = getLastTarget(nums, target);

        return lastTargetIndex-firstTargetIndex+1;
    }

    public int getFirstTarget(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target) {
                if(mid > 0 && nums[mid-1] == target) {
                    r = mid - 1;
                }
                else if(mid == 0 || nums[mid-1] != target)
                    return mid;
            }
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public int getLastTarget(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target) {
                if(mid+1 < n && nums[mid+1] == target) {
                    l = mid+1;
                }
                else if(mid == n-1 || mid+1 < n && nums[mid+1] != target) {
                    return mid;
                }
            }
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

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
        int[] nums = {3,3,3};
        int target = 3;
        int count = new Search().search03(nums, target);
        System.out.println(count);
    }
}
