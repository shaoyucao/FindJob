package com.syc.findJob.algorithm.sort.review1;

public class BinarySearch {

    public int binarySearch(int[] array, int target) {
        if(null == array || array.length == 0)
            return -1;
        int n = array.length;
        return binarySearch2(array, 0, n-1, target);
    }

    public int binarySearch(int[] array, int l, int r, int target) {
        if(l > r)
            return -1;
        int mid = (l+r) / 2;
        if(array[mid] == target)
            return mid;
        else if(array[mid] < target) {
            l = mid+1;
            return binarySearch(array, l, r, target);
        }else{
            r = mid - 1;
            return binarySearch(array, l, r, target);
        }

    }

    public int binarySearch2(int[] array, int l, int r, int target) {
        while(l <= r) {
            int mid = (l + r) / 2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] > target) {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,7};
        int target = 0;
        System.out.println(new BinarySearch().binarySearch(array,target));

    }
}
