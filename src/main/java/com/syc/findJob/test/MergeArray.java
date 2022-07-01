package com.syc.findJob.test;

import java.util.Arrays;

public class MergeArray {

    public int[] mergeArray(int[] array1, int[] array2) {
        if(null == array1 || array1.length == 0) {
            return array2;
        }
        if(null == array2 || array2.length == 0) {
            return array1;
        }

        int n1 = array1.length;
        int n2 = array2.length;

        int[] res = new int[n1+n2];

        int i = 0, j = 0;
        int index = 0;

        while (index != n1 + n2) {
            if (index < n1 + n2 && i >= n1) {
                res[index++] = array2[j++];
            } else if (index < n1 + n2 && j >= n2) {
                res[index++] = array1[i++];
            } else if (i < n1 && array1[i] <= array2[j]) {
                res[index++] = array1[i++];
            } else if (j < n2 && array1[i] > array2[j]) {
                res[index++] = array2[j++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,3,5};
        int[] array2 = new int[]{2,4,6,8,9};
        System.out.println(Arrays.toString(new MergeArray().mergeArray(array1, array2)));
    }

}
