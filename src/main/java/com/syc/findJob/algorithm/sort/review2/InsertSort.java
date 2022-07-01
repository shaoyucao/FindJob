package com.syc.findJob.algorithm.sort.review2;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] array) {
        if(null == array || array.length == 0)
            return;

        int n = array.length;

        for(int i = 1; i < n; ++i) {
            int t = array[i];
            int j = i;
            for( ; j > 0; --j) {
                if(t < array[j-1]) {
                    array[j] = array[j-1];
                }
                else break;
            }
            array[j] = t;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(20, 10, 30);
        new InsertSort().insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
