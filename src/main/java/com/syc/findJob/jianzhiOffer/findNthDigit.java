package com.syc.findJob.jianzhiOffer;

/**
 * 数字序列中某一位的数字
 */
public class findNthDigit {
    public int findNthDigit(int n) {
        if(n < 0)
            return -1;
        int digit = 1;
        while(true) {
            long nums = digit * getTotalNum(digit);
            if(n < nums)
                break;
            ++digit;
            n -= nums;
        }
        int num = getNthNum(n, digit);
        int index = n % digit;
        return getNumAtIndex(num, digit, index);
    }

    public long getTotalNum(int digit) {
        if(digit == 1)
            return 10;
        return 9 * (long) Math.pow(10, digit-1);
    }

    public int getNthNum(int n, int digit) {
        int base = digit == 1 ? 0 : (int) Math.pow(10, digit-1);
        n = n / digit;
        return base+n;
    }

    public int getNumAtIndex(int num, int digit, int index) {
        for(int i = 1; i < digit-index; ++i) {
            num /= 10;
        }
        return num % 10;
    }

    public static void main(String[] args) {
        int n = 1000000000;
        System.out.println(new findNthDigit().findNthDigit(n));
    }
}
