package com.syc.findJob.algorithm.sort;

public class SortUtil {
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * (rangeR-rangeL+1)) + rangeL;
        }
        return array;
    }

    public static int[] generateNearlySortedArray(int n, int swapTimes) {
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = i;
        }

        for(int i = 0; i < swapTimes; i++){
            int randomX = (int)(Math.random()*(n+1));
            int randomY = (int)(Math.random()*(n+1));
            swap(array, randomX, randomY);
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
