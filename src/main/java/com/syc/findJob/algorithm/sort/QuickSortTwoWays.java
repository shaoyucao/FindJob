package com.syc.findJob.algorithm.sort;

public class QuickSortTwoWays {
    public void quickSort(int[] arr) {
        if(null == arr || arr.length == 0)
            return;
        int n = arr.length;
        quickSort(arr, 0, n-1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if(l >= r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int random = (int)(Math.random()*(r-l+1))+l;
        swap(arr, l, random);
        int v = arr[l];
        int i = l + 1, j = r;
        while(true) {
            while(i <= r && arr[i] < v)
                i++;
            while (j >= l+1 && arr[j] > v)
                j--;
            if(i>j)
                break;
            swap(arr, i, j);
            i++;
            j--;
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
