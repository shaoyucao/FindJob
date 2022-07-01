package com.syc.findJob.algorithm.sort.review2;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class QuickSortTwoWays {

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
        int i = l+1, j = r;
        while(true) {
            while(i <= r && array[i] < v) //[l+1...i] < v
                ++i;
            while(j >= l+1 && array[j] > v) //[j...r] > v
                --j;
            if(i > j)
                break;
            swap(array, i, j);
            ++i;
            --j;
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
        int[] array = SortUtil.generateRandomArray(20,30,60);
        new QuickSort().quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
