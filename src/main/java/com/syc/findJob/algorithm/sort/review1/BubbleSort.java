package com.syc.findJob.algorithm.sort.review1;

import com.syc.findJob.algorithm.sort.SortUtil;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] array) {
        if(null == array || array.length == 0)
            return;
        int n = array.length;
        for(int i = 0; i < n-1; i++) { //进行n-1趟冒泡排序
            for(int j = 0; j < n-1-i; j++) { //每次冒泡确定一个最大值的最终位置
                if(array[j] > array[j+1])
                    swap(array, j, j+1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new BubbleSort().bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
