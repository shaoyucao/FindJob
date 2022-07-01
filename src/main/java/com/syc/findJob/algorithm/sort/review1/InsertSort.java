package com.syc.findJob.algorithm.sort.review1;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class InsertSort {

    public void insertSort(int[] array) {
        if(null == array || array.length == 0)
            return;

        int n = array.length;

        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j-1])
                    swap(array, j, j-1);
                else break;
            }
        }
    }

    public void insertSort2(int[] array) {
        if(null == array || array.length == 0)
            return;

        int n = array.length;

        for(int i = 1; i < n; i++) {
            int data = array[i];
            int j = i;
            for( ; j > 0; j--) {
                if(data < array[j-1])
                    array[j] = array[j-1];
                else break;
            }
            array[j] = data;
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
        new InsertSort().insertSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
