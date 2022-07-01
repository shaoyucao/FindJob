package com.syc.findJob.leetCode;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() >= k+1) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
