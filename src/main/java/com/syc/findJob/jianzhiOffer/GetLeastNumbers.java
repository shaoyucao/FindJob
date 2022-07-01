package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    //基于最大堆的解法，时间复杂度为O(nlogk)
    public int[] getLeastNumbers2(int[] arr, int k) {

        if(null == arr || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            //返回负数，不交换；返回正数和0，交换
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int len = arr.length;

        for(int i = 0; i < len; i++) {
            if(i < k) {
                queue.offer(arr[i]);
            }else{
                int top = queue.peek();
                if(arr[i] < top) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    //基于快排partition的解法，时间复杂度为O(n)
    public int[] getLeastNumbers(int[] arr, int k){

        if(null == arr || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }

        int len = arr.length;
        int l = 0, r = len - 1;

        int index = partition(arr, l, r);

        while(index != k-1) {
            if(index > k-1) {
                r = index - 1;
                index = partition(arr, l, r);
            }
            else {
                l = index + 1;
                index = partition(arr, l, r);
            }
        }

        int[] ret = new int[k];
        for(int i = 0; i < k; ++i) {
            ret[i] = arr[i];
        }

        return ret;
    }

    public int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l+1, j = r;
        while(true) {
            while(i <= r && arr[i] < v) {
                ++i;
            }
            while(j >= l+1 && arr[j] > v){
                --j;
            }
            if(i > j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int v = arr[j];
        arr[j] = arr[i];
        arr[i] = v;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] leastNumbers = new GetLeastNumbers().getLeastNumbers2(arr, k);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
