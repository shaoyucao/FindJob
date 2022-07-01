package com.syc.findJob.leetCode;

import java.sql.Array;
import java.util.*;

public class IntersectionII {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();
        for(int v : nums1) {
            map1.put(v, map1.getOrDefault(v,0)+1);
        }
        for(int v : nums2) {
            map2.put(v, map2.getOrDefault(v,0)+1);
        }
        for (int k : map1.keySet()) {
            if (map2.containsKey(k)) {
                res.put(k, Math.min(map1.get(k), map2.get(k)));
            }
        }

        int num = 0;
        for(int k : res.keySet()) {
            num += res.get(k);
        }

        int[] ans = new int[num];
        int index = 0;

        for(int k : res.keySet()) {
            for(int i = 0; i < res.get(k); i++) {
                ans[index++] = k;
            }
        }
        return ans;

    }

    public int[] intersect2(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int v : nums1) {
            map.put(v, map.getOrDefault(v,0)+1);
        }
        for(int v : nums2) {
            if(map.containsKey(v) && map.get(v) > 0) {
                list.add(v);
                map.put(v, map.get(v)-1);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int v : list) {
            res[i++] = v;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(new IntersectionII().intersect2(nums1, nums2)));

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(12));
    }
}
