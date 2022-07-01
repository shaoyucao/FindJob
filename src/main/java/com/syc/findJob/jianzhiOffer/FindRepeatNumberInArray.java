package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class FindRepeatNumberInArray {
    public static void main(String[] args) {
        int[] array = {0,1,3,2};
//        System.out.println(findRepeatNumberInArray(array));
//
//        System.out.println(Arrays.toString(array));
//        System.out.println(findRepeatNumberInArray2(array));


        System.out.println(findRepeatNumberInArray3(array));

    }

    /**
     * 最low方法
     * @param array
     * @return
     */
    public static int findRepeatNumberInArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] == array[j]) {
                    return array[i];
                }
            }
        }
        return 0;
    }

    /**
     * 方法2：先排序再查找
     */
    public static int findRepeatNumberInArray2(int[] array) {
        quickSort(array, 0, array.length-1);
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i+1])
                return array[i];
        }
        return -1;
    }

    /**
     * 方法3：利用数组和数的特征排序并比较
     * @param nums
     * @return
     */
    public static int findRepeatNumberInArray3(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            //利用下标交换，保证i == 元素值
            while(nums[i] != i && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
                if(nums[i] != i && nums[nums[i]] == nums[i] ){ //数组中的值必须和它所在的下标对应的数组中的值相等（确定到了该值的正确位置），同时要求该值在它的当前对应的下标上（有点绕）。
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * 快排方法中，两点注意点:
     * 1.需要使用左指针小于右指针的条件判断，否则会出现栈溢出
     * 2.找到元素的最终位置后，停止该位置重复进入排序判断，使用index-1, index+1来控制，否则同样会出现栈溢出
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        if(left < right) { //需要添加该处的判断，否则会产生栈溢出的异常（考虑一种已经有序的数组，一次排序后，返回的index = 0，若不加判断，则一直在进行循环调用
            int index = partition(array, left, right);
            quickSort(array, left, index-1); //找到该元素的最终位置之后，就不在重复对该元素进行排序，否则会出现栈溢出
            quickSort(array, index+1, right);
        }
    }

    /**
     * partition方法基本思想：
     * 1.选取最左边的元素为基准元素
     * 2.比较左右两个的值和基准元素的大小，交换元素
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] array, int left, int right) {
        int temp = array[left]; // 这里选取最左边的最为基准元素
        while(left < right) {
            while(left < right && array[right] >= temp)
                right--;
            array[left] = array[right];
            while(left < right && array[left] <= temp)
                left++;
            array[right] = array[left];
        }
        array[left] = temp; //别忘了设置回元素值
        return left;
    }
}
