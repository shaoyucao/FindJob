package com.syc.findJob.jianzhiOffer;

import java.util.*;

public class MaxSlidingWindow_Review {

    //暴力解法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] ret = new int[n-k+1];
        for(int i = 0; i <= n-k; ++i) {
            int max = nums[i];
            for(int j = i+1; j < i+k; ++j) {
                max = Math.max(nums[j], max);
            }
            ret[i] = max;
        }
        return ret;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int n = nums.length;
        // 使用双端队列，方便收尾进出
        LinkedList<Integer> indexQueue = new LinkedList<>();
        indexQueue.offer(0);
        //1.先找k内的最大值
        for(int i = 1; i < k; ++i) {
            //把有可能成为窗口中最大值的元素下标入队
            while(!indexQueue.isEmpty() && nums[i] > nums[indexQueue.getLast()]) {
                indexQueue.removeLast();
            }
            indexQueue.addLast(i);
        }
        LinkedList<Integer> res = new LinkedList<>();
        res.add(nums[indexQueue.getFirst()]);
        for(int i = k; i < n; ++i) {
            while(!indexQueue.isEmpty() && nums[i] > nums[indexQueue.getLast()]) {
                indexQueue.removeLast();
            }
            indexQueue.addLast(i);
            if(i - indexQueue.getFirst() >= k) {
                indexQueue.removeFirst();
            }
            res.add(nums[indexQueue.getFirst()]);
        }

        int[] result = new int[res.size()];
        //避坑：这里i的最大值不能是res.size，因为res的大小会缩小
        for(int i = 0; i < result.length; ++i) {
            result[i] = res.removeFirst();
        }
        return result;
    }

    //大顶堆法
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        if(n < k)
            return null;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for(int i = 0; i < k; ++i) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] ret = new int[n-k+1];
        ret[0] = queue.peek()[0];
        int j = 1;
        for(int i = k; i < n; ++i) {
            queue.offer(new int[]{nums[i], i});
            while(i-queue.peek()[1] >= k) {
                queue.poll();
            }
            ret[j] = queue.peek()[0];
            ++j;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        System.out.println(Arrays.toString(new MaxSlidingWindow_Review().maxSlidingWindow2(nums, k)));
    }
}
