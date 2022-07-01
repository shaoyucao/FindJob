package com.syc.findJob.algorithm.sort.review1;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class HeapSort {
    //使用插入删除方法进行堆排序
    public void heapSort(int[] array) {
        if(null == array || array.length == 0) {
            return;
        }
        int n = array.length;
        MaxHeap maxHeap = new MaxHeap(n+1);
        for(int i = 0; i < n; i++) {
            maxHeap.insert(array[i]);
        }

        for(int i = n-1; i >= 0; i--){
            array[i] = maxHeap.remove();
        }
    }

    //使用heapify方法进行堆排序
    public void heapSort2(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        int n = array.length;
        for(int i = n-1; i >=0; i--) {
            array[i] = maxHeap.remove();
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new HeapSort().heapSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
