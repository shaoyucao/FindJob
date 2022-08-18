package com.syc.findJob.jianzhiOffer;

import java.util.HashSet;

/**
 * 最长连续序列
 */
public class LongestConsecutive {
    /**
     * 哈希表法，对于元素x,依次查找x+1, x+2, ...是否在数组中，找一个最长的连续数组
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        //元素去重
        for(int num : nums) {
            set.add(num);
        }
        int maxLen = 1;
        for(int cur : nums) {
            if(set.contains(cur-1))
                continue;
            int curLen = 1;
            while(set.contains(cur+1)) {
                curLen++;
                cur++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,7,6,4};
        System.out.println(new LongestConsecutive().longestConsecutive(nums));
    }
}
