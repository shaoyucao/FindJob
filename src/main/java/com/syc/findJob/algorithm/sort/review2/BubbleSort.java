package com.syc.findJob.algorithm.sort.review2;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        if(null == arr || arr.length == 0)
            return;

        int n = arr.length;

        for(int i = 0; i < n; ++i) { //遍历的趟数 n-1趟
            for(int j = 0; j < n-1-i; ++j) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.generateRandomArray(20, 10, 50);
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
