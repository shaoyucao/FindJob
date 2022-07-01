package com.syc.findJob.algorithm.sort.review2;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] array) {
        if(null == array || array.length == 0)
            return;
        int n = array.length;
        mergeSort(array, 0, n-1);
    }

    public void mergeSort(int[] array, int l, int r) {
        if(l >= r)
            return ;

        int mid = (l + r) >> 1;
        mergeSort(array, l, mid);
        mergeSort(array, mid+1, r);
        merge(array, l, mid, r);
    }

    //将数组分别对[l, mid]以及[mid+1, r]做归并
    public void merge(int[] array, int l, int mid, int r) {
        int n = r - l + 1;
        int[] aux = new int[n];

        //填充辅助数组
        for(int i = l; i <= r; ++i) {
            aux[i-l] = array[i];
        }

        int i = l, j = mid+1;
        for(int k = l; k <= r; ++k) {
            if(i > mid && j <= r) {
                array[k] = aux[j-l];
                ++j;
            }
            else if(j > r && i <= mid) {
                array[k] = aux[i-l];
                ++i;
            }
            else if(aux[i-l] < aux[j-l]) {
                array[k] = aux[i-l];
                ++i;
            }else {
                array[k] = aux[j-l];
                ++j;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(20, 30, 50);
        new MergeSort().mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
