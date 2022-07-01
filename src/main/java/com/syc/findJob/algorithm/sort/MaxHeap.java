package com.syc.findJob.algorithm.sort;

import java.util.Arrays;

public class MaxHeap<T> {
    private int count;
    private int[] array;

    public MaxHeap(int capacity) {
        array = new int[capacity+1];
        count = 0;
    }

    public void put(int item) {
        array[++count] = item;
        shiftUp(count);
    }

    //直接插入到一个堆中
    public static void heapSort1(int[] arr, int n) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        for(int i = 0; i < n; i++) {
            maxHeap.put(arr[i]);
        }

        for(int i = n-1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
    }

    public static void heapSort2(int[] arr, int n) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr, n);
        for(int i = n-1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
    }



    public MaxHeap(int[] data, int n) {
        array = new int[n+1];
        for(int i = 0; i < n; i++) {
            array[i+1] = data[i];
        }
        count = n;
        //从第一个非叶子节点开始进行shiftDown操作
        for(int i = n/2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size(){
        return count;
    }

    public int remove() {
        if(count == 0)
            return -1;
        int temp = array[1];
        swap(array, 1, count--);
        shiftDown(1);
        return temp;
    }

    private void shiftUp(int k) {
        while(k > 1 && array[k/2] < array[k]) {
            swap(array, k/2, k);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while(2 * k <= count) {
            int j = 2 * k; //arrar[k] 和 array[j]的元素交换，和左边的元素交换
            if(j+1 <= count && array[j+1] > array[j]) { //只有当右孩子存在，并且右孩子大于左孩子时，和右孩子交换
                j += 1;
            }
            if(array[k] >= array[j])
                break;
            swap(array, k, j);
            k = j;
        }
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }



    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) {
            int item = (int) (Math.random() * 101);
            maxHeap.put(item);
            arr[i] = item;
        }
        System.out.println("maxHeap size is : " + maxHeap.size());
        for(int i = 1; i <= maxHeap.size(); i++) {
            System.out.print(maxHeap.array[i] + " ");
        }
        System.out.println();

        heapSort2(arr,10);
        System.out.println("sorted array is : " + Arrays.toString(arr));



//        System.out.println("remove item : " + maxHeap.remove());
//        for(int i = 1; i <= maxHeap.size(); i++) {
//            System.out.print(maxHeap.array[i] + " ");
//        }

        while( !maxHeap.isEmpty() ) {
            System.out.print(maxHeap.remove() + " ");
        }
        System.out.println();

    }


}
