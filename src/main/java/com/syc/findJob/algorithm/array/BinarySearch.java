package com.syc.findJob.algorithm.array;

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int n = array.length;
        int left = 0, right = n - 1;
        while(left <= right) { //循环不变量
            int mid = (left + right) / 2;
            if(array[mid] == target)
                return mid;
            if(array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public int binarySearch2(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int n = array.length;
        int left = 0, right = n;
        while(left < right) { //循环不变量，在[left, right)区间进行搜索
            int mid = (left + right) / 2;
            if(array[mid] == target)
                return mid;
            if(array[mid] < target)
                left = mid + 1; //包含左区间
            else
                right = mid; //不包含右区间
        }
        return -1;
    }
}
