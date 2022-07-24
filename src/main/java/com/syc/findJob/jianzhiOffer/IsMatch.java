package com.syc.findJob.jianzhiOffer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class IsMatch {
    /**
     * 递归思路
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        if(p.isEmpty())
            return s.isEmpty();

        //查看首元素是否一致
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //如果p的下一个字符是“*”
        if(p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }else{
            //一般情况，匹配后继续比较
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }

    /**
     * 动态规划思路
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        //dp[i][j]表示s的前i位于p的前j位能否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 0; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2] || match(s, p, i, j-1) && dp[i-1][j];
                }
                else {
                    if(match(s, p, i, j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean match(String s, String p, int i, int j) {
        if(i == 0)
            return false;
        if(p.charAt(j-1) == '.')
            return true;
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        String str = "";

        System.out.println(str.isEmpty());
    }
}
