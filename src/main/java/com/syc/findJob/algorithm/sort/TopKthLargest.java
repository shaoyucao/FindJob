package com.syc.findJob.algorithm.sort;

import java.util.Arrays;

/**
 * 数组中前k个大的数
 */
public class TopKthLargest {

    //使用快排方法，时间复杂度O(nlogn)
    public int[] topKthLargest(int[] arr, int k) {
        if(null == arr || arr.length == 0)
            return new int[0];
        int n = arr.length;
        quickSort(arr, 0, n-1);

        int[] res = new int[k];
        int index = 0;
        for(int i = n-1; i >= n-k; --i) {
            res[index++] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int l, int r) {
        if(l >= r)
            return;
        int index = partition(arr, l, r);
        quickSort(arr, l, index-1);
        quickSort(arr, index+1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int randomIndex = (int)(Math.random()*(r-l+1))+l;
        swap(arr, l, randomIndex);
        int val = arr[l];
        int i = l+1, j = r;
        while(true) {
            while(j > l && arr[j] > val)
                j--;
            while(i <= r && arr[i] < val)
                i++;
            if(i > j)
                break;
            swap(arr, i, j);
            j--;
            i++;
        }
        swap(arr, l, j); //找到位置之后，最终需要交换一次
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2, 7, 8};
        int k = 3;
        System.out.println(Arrays.toString(new TopKthLargest().topKthLargest(arr, k)));
    }

    //基于快排中partition的思想，使得整体的时间复杂度为O(n)
    //该方法找的是 前k个排好序的最大数
    public int[] topKthLargest2(int[] arr, int k) {
        if(null == arr || arr.length == 0)
            return new int[0];
        int n = arr.length;
        int l = 0, r = n-1;

        while(l < r) {
            int index = partition(arr, l, r);
            if(index == n-k) {
                if(index == n-1 || arr[index+1] >= arr[index]) {
                    break;
                }else {
                    quickSort(arr, index+1, r);
                    break;
                }
            }
            else if(index < n-k) {
                if(arr[index+1] >= arr[index])
                    break;
                else {
                    l = index+1;
                }
            }
            else {
                r = index - 1;
            }
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = n-1; i >= n-k; --i) {
            res[index++] = arr[i];
        }
        return res;
    }

}
