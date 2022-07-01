package com.syc.findJob.jianzhiOffer;

public class MinArray {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        int mid = l;
        while(numbers[l] >= numbers[r]){
            if(l+1 == r){
                mid = r;
                break;
            }
            mid = (l+r) / 2;
            if(numbers[mid] == numbers[l] && numbers[mid] == numbers[r])
                return minInOrder(numbers, l, r);
            if(numbers[mid] >= numbers[l]){
                l = mid;
            }
            else {
                r = mid;
            }
        }
        return numbers[mid];
    }

    private int minInOrder(int[] numbers, int l, int r) {
        int res = numbers[l];
        for(int i = l; i <= r; i++) {
            res = Math.min(numbers[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,4,5};
        System.out.println(new MinArray().minArray(numbers));
    }
}
