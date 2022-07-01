package com.syc.findJob.algorithm.sort;

import java.util.Arrays;

public class QuickSortThreeWays {
    public void quickSort(int[] arr){
        if(null == arr || arr.length == 0){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if(l >= r)
            return;

        int random = (int) (Math.random()*(r-l+1)) + l;
        swap(arr, l, random);
        int v = arr[l];

        int lt = l; //[l+1,lt] < v
        int gt = r+1; //[gt,r] > v
        int i = l+1;
        while(i < gt) {
            if(arr[i] < v) {
                swap(arr, i, lt+1);
                lt++;
                i++;
            }
            else if (arr[i] > v) {
                swap(arr, i, gt-1);
                gt--;
            }
            else {
                i++;
            }
        }
        swap(arr, lt, l);

        quickSort(arr, l, lt-1);
        quickSort(arr, gt, r);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new QuickSortThreeWays().quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
