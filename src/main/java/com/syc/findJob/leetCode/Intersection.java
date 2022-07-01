package com.syc.findJob.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int item : nums1) {
            set.add(item);
        }
        for(int item : nums2) {
            if(set.contains(item)) {
                res.add(item);
            }
        }
        int size = res.size();
        int[] arr = new int[size];
        int i = 0;
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()) {
            arr[i++] = iterator.next();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(new Intersection().intersection(nums1,nums2)));
    }
}
