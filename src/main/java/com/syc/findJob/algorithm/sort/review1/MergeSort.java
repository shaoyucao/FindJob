package com.syc.findJob.algorithm.sort.review1;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] array) {
        if(null == array || array.length == 0)
            return;

        int n = array.length;

        mergeSort(array, 0, n-1);

    }

    public void mergeSort(int[] array, int left, int right) {
        if(left >= right)
            return;
        int mid = (left + right) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    //mergeSortImprove
    public void mergeSort2(int[] array, int left, int right) {
        if(left >= right)
            return;
        int mid = (left + right) / 2;

        mergeSort2(array, left, mid);
        mergeSort2(array, mid+1, right);
        if(array[mid] > array[mid+1]) //对于整体已经有序的情况（array[mid] <= array[mid+1]，不再进行归并）
            merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n = right - left + 1;
        int[] aux = new int[n];

        for(int i = left; i <= right; i++) {
            aux[i-left] = array[i];
        }
        int i = left, j = mid+1;
        for(int k = left; k <= right; k++) {
            if(i > mid) {
                array[k] = aux[j-left];
                j++;
            }
            else if(j > right) {
                array[k] = aux[i-left];
                i++;
            }
            else if(aux[i-left] < aux[j-left]){
                array[k] = aux[i-left];
                i++;
            }
            else{
                array[k] = aux[j-left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new MergeSort().mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
