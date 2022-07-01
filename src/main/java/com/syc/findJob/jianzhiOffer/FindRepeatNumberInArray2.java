package com.syc.findJob.jianzhiOffer;

public class FindRepeatNumberInArray2 {
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        System.out.println(findRepeatNumber(arr));
    }

    public static int findRepeatNumber(int[] arr) {
        //安全性判断
        if(null == arr || arr.length <= 0) {
            return -1;
        }
        int start = 1;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;

            int num = count(arr, arr.length, start, mid);
            if(start == end) {
                if(num > 1)
                    return start;
            }
            if(num == mid - start + 1){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int count(int[] arr, int length, int start, int end) {
        int count = 0;
        for(int i = 0; i < length; i++) {
            if(arr[i] >= start && arr[i] <= end) {
                ++count;
            }
        }
        return count;
    }
}
