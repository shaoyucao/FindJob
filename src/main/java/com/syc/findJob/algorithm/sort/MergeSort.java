package com.syc.findJob.algorithm.sort;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if(null == arr || arr.length == 0) {
            return;
        }
        int n = arr.length;
        mergeSort(arr, 0, n-1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if(left >= right) //当只有一个元素时，不再排序，已经有序
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }



    public void merge(int[] arr, int left, int mid, int right) {
        int n = right - left + 1;
        int[] aux = new int[n];
        for(int i = left; i <= right; i++) {
            aux[i-left] = arr[i];
        }
        int i = left, j = mid + 1;
        for(int k = left; k <= right; k++) {
            if(i > mid) {
                arr[k] = aux[j-left];
                j++;
            }
            else if(j > right) {
                arr[k] = aux[i-left];
                i++;
            }
            else if(aux[i-left] < aux[j-left]) {
                arr[k] = aux[i-left];
                i++;
            }
            else{
                arr[k] = aux[j-left];
                j++;
            }
        }
    }
}
