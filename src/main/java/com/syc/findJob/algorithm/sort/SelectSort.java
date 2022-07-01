package com.syc.findJob.algorithm.sort;

public class SelectSort {
    public void selectSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int n = array.length;

        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i; j < n; j++) {
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
