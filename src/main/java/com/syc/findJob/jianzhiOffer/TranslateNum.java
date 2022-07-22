package com.syc.findJob.jianzhiOffer;

/**
 * 把数组翻译成字符串
 */
public class TranslateNum {
    /**
     * 动态规划
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if(num < 0)
            return 0;
        if(num == 0)
            return 1;
        int temp = num;
        int n = 0;
        while(temp != 0) {
            temp /= 10;
            ++n;
        }
        int[] nums = new int[n];

        for(int i = 0; i < n; ++i) {
            nums[n-i-1] = num % 10;
            num /= 10;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; ++i) {
            if(nums[i-1] == 1 || nums[i-1] == 2 && nums[i] < 6) {
                if(i >= 2) {
                    dp[i] = dp[i-1] + dp[i-2];
                }
                else
                    dp[i] = dp[i-1] + 1;
            }
            else
                dp[i] = dp[i-1];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int num = 1225;
        System.out.println(new TranslateNum().translateNum(num));
    }
}
