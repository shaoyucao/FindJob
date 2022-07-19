package com.syc.findJob.jianzhiOffer;

import java.util.*;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(null == nums || nums.length == 0 || k == 0)
            return new int[0];
        int n = nums.length;
        LinkedList<Integer> indexQueue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        indexQueue.offer(0);
        for(int i = 1; i < k; ++i) {
            while(!indexQueue.isEmpty() && nums[i] > nums[indexQueue.getLast()]){
                indexQueue.removeLast();
            }
            indexQueue.addLast(i);
        }
        res.add(nums[indexQueue.getFirst()]);
        for(int i = k; i < n; ++i) {
            while(!indexQueue.isEmpty() && nums[i] > nums[indexQueue.getLast()]){
                indexQueue.removeLast();
            }
            indexQueue.addLast(i);
            if(i - indexQueue.getFirst() >= k)
                indexQueue.removeFirst();
            res.add(nums[indexQueue.getFirst()]);
        }

        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
