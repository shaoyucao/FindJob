package com.syc.findJob.algorithm.sort.review1;

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
        int p = partition2(array, l, r);
        quickSort(array, l, p - 1);
        quickSort(array, p+1, r);
    }

    //对[l...r]的元素进行快速排序
    //返回元素p表示在[l...p-1]<v, [p+1...r]>v
    private int partition(int[] array, int l, int r) {
        int v = array[l];
        int j = l; //j表示在[l+1...j]的范围内<v， 而i表示在[j+1...i)的范围内>v
        for(int i = l+1; i <= r; i++){
            if(array[i] < v) {
                swap(array, ++j, i);
            }
        }
        swap(array, l, j);
        return j;
    }

    //双路快排
    private int partition2(int[] array, int l, int r) {
        int v = array[l];
        //array[l+1...i)<= v, array(j...r] >= v
        int i = l+1;
        int j = r;
        while(true) {
            while(i <= r && array[i] < v)
                i++;
            while(j >= l + 1 && array[j] > v)
                j--;
            if(i > j)
                break;
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, l, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new QuickSort().quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
