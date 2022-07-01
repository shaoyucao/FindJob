package com.syc.findJob.algorithm.sort;

public class InsertSort {
    public void insertSort(int[] array) {
        if(null == array || array.length <= 1 ) {
            return;
        }
        int n = array.length;
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j-1])
                    swap(array, j, j-1);
                else
                    break;
            }
        }
    }

    //insertSortImprove
    public void insertSort2(int[] array) {
        if(null == array || array.length <= 1)
            return;
        int n = array.length;
        for(int i = 1; i < n; i++) {
            int temp = array[i];
            int j;
            for(j = i; j > 0 && temp < array[j-1]; j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


}


