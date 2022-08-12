package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

/**
 * minArray 旋转数组的最小数字
 *          特别注意，如果把前面的0个元素，搬到后面，也是数组的一种旋转，即数组保持升序的情况
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        int mid = l;
        while(numbers[l] >= numbers[r]){
            if(l+1 == r){
                mid = r;
                break;
            }
            mid = (l+r) / 2;
            if(numbers[mid] == numbers[l] && numbers[mid] == numbers[r])
                return minInOrder(numbers, l, r);
            if(numbers[mid] >= numbers[l]){
                l = mid;
            }
            else {
                r = mid;
            }
        }
        return numbers[mid];
    }

    private int minInOrder(int[] numbers, int l, int r) {
        int res = numbers[l];
        for(int i = l; i <= r; i++) {
            res = Math.min(numbers[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4,5,6,7,0,1,2};
        System.out.println(new MinArray().minArray4(numbers));
    }

    ////////////// review
    //方法1：一次遍历

    /**
     * 时间复杂度O(n),空间复杂度O(1)
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if(null == numbers || numbers.length == 0)
            return -1;
        int n = numbers.length;
        for(int i = 0; i < n-1; ++i) {
            if(numbers[i] > numbers[i+1])
                return numbers[i+1];
        }
        return numbers[0];
    }


    /**
     * 快速排序，时间O(nlogn), 空间o(1)
     * @param numbers
     * @return
     */
    public int minArray3(int[] numbers) {
        if(null == numbers || numbers.length == 0)
            return -1;
        Arrays.sort(numbers);
        return numbers[0];
    }


    /**
     * 正常解法
     * 基于二分查找实现，时间复杂度O(logn)， 空间复杂度o(1)
     * @param numbers
     * @return
     */
    public int minArray4(int[] numbers) {
        if(null == numbers || numbers.length == 0)
            return -1;
        if(numbers[0] < numbers[numbers.length-1]) //移动了0个元素
            return numbers[0];
        return findMin(0, numbers.length-1, numbers);
    }

    //4,5,6,7,0,1,2
    public int findMin(int l, int r, int[] numbers) {
        if(l == r) {
            return numbers[l];
        }
        int mid = (l + r) >> 1;
        if(numbers[l] < numbers[mid]) {
            return findMin(mid, r, numbers);
        }
        else if (numbers[l] > numbers[mid]){
            return findMin(l, mid, numbers);
        }
        else { //相等时只能顺序查找
            return findMinBySequence(l, r, numbers);
        }
    }

    public int findMinBySequence(int l, int r, int[] numbers) {
        int min = numbers[l];
        for(int i = l; i <= r; ++i) {
            min = Math.min(numbers[i], min);
        }
        return min;
    }

}
