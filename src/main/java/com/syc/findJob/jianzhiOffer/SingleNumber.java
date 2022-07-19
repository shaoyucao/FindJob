package com.syc.findJob.jianzhiOffer;

/**
 * 数组中只出现1次的1个数，（其他数字均出现了三次）
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(null == nums || nums.length < 4)
            return -1;
        //计算每一位出现的数字的和
        int[] sumBit = new int[32];
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            int bitNum = 1;
            for(int j = 31; j >= 0; --j) {
                if((nums[i] & bitNum) != 0) { //这里千万不能用 ==1 来判
                    sumBit[j] += 1;
                }
                bitNum = bitNum << 1;
            }
        }

        int ret = 0;
        for(int i = 0; i < 32; ++i) {
            ret = ret << 1;
            ret += sumBit[i] % 3;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,4,3,5,5,5};
        int ret = new SingleNumber().singleNumber(nums);
        System.out.println(ret);
    }
}
