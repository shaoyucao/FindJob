package com.syc.findJob.algorithm.sort;

import com.sun.media.sound.RIFFInvalidDataException;

public class QuickSort {
    public void quickSort(int[] arr) {
        if(null == arr || arr.length == 0)
            return;
        int n = arr.length;
        quickSort(arr, 0, n-1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if(l >= r)
            return;
        int p = partion(arr, l, r);
        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);
    }

    public int partion(int[] arr, int l, int r) {
        int random = (int)(Math.random()*(r-l+1))+l;
        swap(arr, l, random);
        int v = arr[l];
        int j = l;
        for(int i = j+1; i <= r; i++) {
            if(arr[i] < v) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


}
