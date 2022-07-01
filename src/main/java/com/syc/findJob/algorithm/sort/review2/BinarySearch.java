package com.syc.findJob.algorithm.sort.review2;

public class BinarySearch {

    public int binarySearch(int[] array, int target) {
        if(null == array || array.length == 0)
            return -1;

        int n = array.length;

        return binarySearch(array, target,0, n-1);
    }

    public int binarySearch(int[] array, int target, int l, int r) {

        if(l > r)
            return -1;
        int mid = (l+r) >> 1;

        if(target == array[mid])
            return mid;
        if(target > array[mid])
            return binarySearch(array, target, mid+1, r);
        else return binarySearch(array, target, l, mid-1);

    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,8,9};
        System.out.println(new BinarySearch().binarySearch(array, 4));
    }
}
