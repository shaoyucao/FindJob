package com.syc.findJob.algorithm.sort;

import java.util.Arrays;

public class MySortTest {
    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(50, 10, 30);
        System.out.println(Arrays.toString(array));
        new QuickSortThreeWays().quickSort(array);
        System.out.println(Arrays.toString(array));


        long start1 = System.currentTimeMillis();
        new SelectSort().selectSort(array);
        long end1 = System.currentTimeMillis();
        System.out.println("sort time : " + (end1 - start1));
        System.out.println(Arrays.toString(array));
    }
}
