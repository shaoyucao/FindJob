package com.syc.findJob.jianzhiOffer;

/**
 * 斐波那契数列
 */
public class Fib {

    /**
     * 递归实现，时间复杂度(k^n)，空间O(n)
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return fib(n-1) + fib(n-2);
    }

    /**
     * 动态规划，时间复杂度O(n), 空间复杂度O(n)
     * @param n
     * @return
     */

    public int fib2(int n) {
        if(n < 1)
            return 0;
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2; i <= n; ++i) {
            mem[i] = (mem[i-1] + mem[i-2]) % mod;
        }
        return mem[n];
    }

    /**
     * 动态规划，空间优化(滚动数组），时间复杂度O(n), 空间复杂度O(1)
     * @param n
     * @return
     */
    public int fib2_2(int n) {
        if(n < 1)
            return 0;
        int x;
        int y = 0;
        int r = 1;
        for(int i = 2; i<= n; ++i) {
            x = y;
            y = r;
            r = (x + y) % mod;
        }
        return r;
    }

    /**
     * 使用"大小数"方法，思路和滚动数组是一致的，这种更加方便记忆
     * @param n
     * @return
     */
    public int fib2_3(int n) {
        if(n < 1)
            return 0;
        int small = 0;
        int big = 1;
        int ret = 0;
        for(int i = 2; i<= n; ++i) {
            ret = (small + big) % mod;
            small = big;
            big = ret;
        }
        return ret;
    }

    /**
     * 记忆化搜索，时间复杂度O(n), 空间复杂度O(n)
     * @param n
     * @return
     */

    private static int mod = 1000000007;
    public int fib3(int n) {
        if(n < 1)
            return 0;
        int[] mem = new int[n+1];
        return getN(n, mem);
    }

    public int getN(int n, int[] mem) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(mem[n] != 0)
            return mem[n];
        mem[n] = (getN(n-1, mem) + getN(n-2, mem)) % mod;
        return mem[n];
    }



    public static void main(String[] args) {
        int n = 7;
        System.out.println(new Fib().fib2_3(n));
    }
}
