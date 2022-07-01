package com.syc.findJob.algorithm.sort.review2;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class SelectSort {

    public void selectSort(int[] array) {
        if(null == array || array.length == 0) {
            return;
        }

        int n = array.length;

        for(int i = 0; i < n; ++i) {
            int minIndex = i;
            for(int j = i+1; j < n; ++j) {
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            if(minIndex != i)
                swap(array, i, minIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(20, 10, 30);
        new SelectSort().selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
