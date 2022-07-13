package com.syc.findJob.jianzhiOffer;

import java.util.*;

/** 方法1：快排思想，每次正常插入元素，在取元素的时候，每次都先排序，再取数，时间效率O(n^2logn) */
public class MedianFinder {

    /** initialize your data structure here.*/

    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        if(null == list || list.size() == 0)
            return 0;
        int n = list.size();
        int mid = n >> 1;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if((n & 1) == 1) {
            return list.get(mid);
        }else {
            return (list.get(mid-1) + list.get(mid))/2.0;
        }
    }
}

/**
 * 方法2： 使用插入排序的思想，将时间效率降低为O(n)
 */
class MedianFinder2 {

    List<Integer> list;
    public MedianFinder2() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int n = list.size();
        if(list.size() == 0 || list.get(n-1) <= num) {
            list.add(num);
            return;
        }
        list.add(list.get(n-1));
        int i = n-1;
        for( ; i >= 0; --i) {
            if(list.get(i) > num) {
                list.set(i+1, list.get(i));
            }else {
                list.set(i+1, num);
                break;
            }
        }
        if(i == -1)
            list.set(0, num);
    }

    public double findMedian() {
        if(null == list || list.size() == 0)
            return 0;
        int n = list.size();
        int mid = n >> 1;
        if((n & 1) == 1) {
            return list.get(mid);
        }else{
            return (list.get(mid-1) + list.get(mid))/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder3 medianFinder3 = new MedianFinder3();
        medianFinder3.addNum(5);
        medianFinder3.addNum(1);
        System.out.println(medianFinder3.findMedian());

    }
}

/**
 * 方法3：基于最大堆和最小堆的实现，插入的时间复杂度为O(logn)，获取中位数的时间复杂度为O(1)
 */
class MedianFinder3 {

    /** initialize your data structure here. */
    Queue<Integer> minQ, maxQ; //A是一个小顶堆，B是一个大顶堆
    public MedianFinder3() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>((x, y) -> {
            return y - x;
        });
    }
    public void addNum(int num) {
        if(minQ.size() == maxQ.size()) { //偶数时，插入小顶推，需要先插入到大顶堆中。
            maxQ.offer(num);
            minQ.offer(maxQ.poll());
        }else{
            minQ.offer(num);
            maxQ.offer(minQ.poll());
        }
    }

    public double findMedian() {
        return minQ.size() == maxQ.size() ? (minQ.peek() + maxQ.peek()) / 2.0 : minQ.peek();
    }
}
