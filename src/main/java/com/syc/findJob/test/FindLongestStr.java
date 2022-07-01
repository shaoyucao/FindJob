package com.syc.findJob.test;

import java.util.ArrayList;
import java.util.List;

public class FindLongestStr {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();

        if(null == nums || nums.length == 0)
            return res;

        int l = 0, r = 0;
        int n = nums.length;

        while(r < n) {
            while( r < n-1 && nums[r] + 1 == nums[r+1]){
                r++;
            }
            StringBuilder sb = new StringBuilder();
            if(l == r) {
                res.add(Integer.toString(nums[l]));
            }else{
                sb.append(nums[l]);
                sb.append("->");
                sb.append(nums[r]);
                res.add(sb.toString());
            }
            r++;
            l = r;
        }
        return res;
    }

    public List<String> summaryRanges2(int[] nums) {

        List<String> res = new ArrayList<>();

        if(null == nums || nums.length == 0)
            return res;

        int i = 0, n = nums.length;

        while(i < n) {
            int l = i;
            i++;
            while(i < n && nums[i-1]+1 == nums[i]) {
                i++;
            }
            int r = i-1;
            StringBuilder sb = new StringBuilder(Integer.toString(nums[l]));
            if(l < r) {
                sb.append("->");
                sb.append(nums[r]);
            }
            res.add(sb.toString());
        }
        return  res;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(new FindLongestStr().summaryRanges2(nums));

    }
}
