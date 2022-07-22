package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 */
public class LengthOfLongestSubstring {
    /**
     * 动态规划（力扣上这题没有明确说字符一定在'a'~'z'之间，不能采用数组形式判断字符是否出现）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0)
            return 0;
        int n = s.length();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        //dp表示以i为结尾的字符串的最长长度
        int[] dp = new int[n];
        //两个数组都进行初始化
        dp[0] = 1;
        pos[s.charAt(0)-'a'] = 0;
        for(int i = 1; i < n; ++i) {
            char c = s.charAt(i);
            int preIndex = pos[c-'a'];
            //第i个字符之前没有出现过，或者之前出现的位置超出了前一个字符的最长长度，则新的长度需要加1
            if(preIndex < 0 || i-preIndex > dp[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            else {
                dp[i] = i-preIndex;
            }
            pos[c-'a'] = i;
        }
        int max = 0;
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划+哈希表，对前一种方法的改进，适用于非小写字母的情况；同时对空间进行了优化
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(null == s || s.length() == 0)
            return 0;
        int n = s.length();
        Map<Character, Integer> posMap = new HashMap<>();
        int maxLength = 0, curLength = 0;
        for(int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            //第i个字符之前没有出现过，或者之前出现的位置超出了前一个字符的最长长度，则新的长度需要加1
            if(!posMap.containsKey(c) || i-posMap.get(c) > curLength) {
                ++curLength;
            }
            else {
                curLength = i-posMap.get(c);
            }
            posMap.put(c, i);
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(str));
    }
}
