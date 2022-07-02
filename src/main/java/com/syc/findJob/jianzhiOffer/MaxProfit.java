package com.syc.findJob.jianzhiOffer;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        if(null == prices || prices.length <= 1)
            return 0;
        int n = prices.length;
        for(int i = 0; i < n; ++i) {
            min = Math.min(min, prices[i]);
            if(prices[i] - min > res)
                res = prices[i] - min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int res = new MaxProfit().maxProfit(prices);
        System.out.println(res);
    }
}
