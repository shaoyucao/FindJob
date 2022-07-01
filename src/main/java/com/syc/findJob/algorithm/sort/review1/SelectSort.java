package com.syc.findJob.algorithm.sort.review1;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class SelectSort {
    private void selectSort(int[] array) {
        if(null == array || array.length == 0)
            return;

        int n = array.length;

        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            if(minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new SelectSort().selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
