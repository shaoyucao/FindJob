package com.syc.findJob.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    // 2, 4, 4, 8 -> 8 -> 2, 3
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            if(numbers[l] + numbers[r] > target) {
                r--;
            }
            else if(numbers[l] + numbers[r] < target) {
                l++;
            }
            else return new int[]{l+1, r+1};
        }
        return new int[2];
    }

    public int[] twoSum2(int[] numbers, int target) {
        for(int i = 0; i < numbers.length-1; i++) {
            int res = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
            if(res != -1)
                return new int[]{i+1, res+1};
        }
        return new int[2];
    }

    public int binarySearch(int[] numbers, int l, int r, int target) {
        if(l <= r) {
            int mid = (l+r) / 2;
            if(numbers[mid] == target)
                return mid;
            else if(target < numbers[mid]) {
                r = mid - 1;
            }
            else if(target > numbers[mid]) {
                l = mid + 1;
            }
            return binarySearch(numbers, l, r, target);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = new int[] {-1,0};
        int target = -1;
        int[] arr = new TwoSum2().twoSum2(numbers, target);
        System.out.println(Arrays.toString(arr));
    }
}
