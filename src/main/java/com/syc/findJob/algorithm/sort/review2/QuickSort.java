package com.syc.findJob.algorithm.sort.review2;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] array) {
        if(null == array || array.length == 0)
            return;
        int n = array.length;
        quickSort(array, 0, n-1);
    }

    public void quickSort(int[] array, int l, int r) {
        if(l >= r)
            return;
        int index = partition(array, l, r);
        quickSort(array, l, index-1);
        quickSort(array, index+1, r);
    }

    public int partition(int[] array, int l, int r) {
        int random = (int)(Math.random()*(r-l+1))+l;
        swap(array, l, random);
        int v = array[l];
        int j = l; // [l+1...j]都 <v
        for(int i = l+1; i <= r; ++i) { //[l+1, i)都 >v
            if(array[i] < v) {
                swap(array, ++j, i);
            }
        }
        swap(array, l, j);
        return j;
    }

    void swap(int[] array, int i, int j) {
        int t = array[j];
        array[j] = array[i];
        array[i] = t;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(20, 10, 30);
        new QuickSort().quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
