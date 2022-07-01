package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

/**
 * 快排的注意事项参考：
 * @see FindRepeatNumberInArray
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,8,7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= temp)
                right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}

class QuickSortPractice {
    public static void main(String[] args) {
        int[] arr = {2,1,3,0,8};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

}
