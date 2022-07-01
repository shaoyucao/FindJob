package com.syc.findJob.leetCode;

public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(l < r) {
            int area = (r-l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            if(height[l] <= height[r])
                l++;
            else r--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new MaxArea().maxArea(height));
    }
}
