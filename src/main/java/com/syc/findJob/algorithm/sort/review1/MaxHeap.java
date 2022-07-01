package com.syc.findJob.algorithm.sort.review1;

import java.util.Arrays;

public class MaxHeap {
    private int[] array;
    private int count;

    //1.初始化
    public MaxHeap(int capacity){
        array = new int[capacity+1];
        count = 0;
    }

    //构造器2
    //使用heapify方法，自动构造一颗大顶堆
    public MaxHeap(int[] data) {
        int n = data.length;
        array = new int[n+1];
        for(int i = 0; i < n; i++){
            array[i+1] = data[i];
        }
        count = n;
        //heapify过程,从第一个非叶子节点开始进行shiftDown操作
        for(int i = n/2; i >= 1; i--){
            shiftDown(i);
        }

    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    //2.向堆中插入一个元素
    public void insert(int data) {
        array[++count] = data;
        shiftUp(count);//将第count个元素进行上移
    }

    private void shiftUp(int k) {
        while(k > 1 && array[k] > array[k/2]){
            swap(array, k, k/2);
            k /= 2;
        }
    }

    //3.向堆中删除一个元素
    public int remove(){
        if(count == 0){
            return -1;
        }
        int data = array[1];
        swap(array, 1, count--);
        shiftDown(1);
        return data;
    }

    private void shiftDown(int k) {
        while(2 * k <= count){
            int j = 2 * k; //j表示要交换的那个元素
            if(j+1 <= count && array[j+1] > array[j]) {
                j += 1;
            }
            if(array[k] >= array[j])
                break;
            swap(array, k, j);
            k = j;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) {
            int item = (int) (Math.random() * 101);
            maxHeap.insert(item);
            arr[i] = item;
        }
        System.out.println("generated array is : " + Arrays.toString(arr));
        System.out.print("maxHeap is : ");
        for(int i = 1; i <= maxHeap.size(); i++) {
            System.out.print(maxHeap.array[i] + " ");
        }
        System.out.println();

    }
}
