package com.syc.findJob.jianzhiOffer;

import java.util.*;

/**
 * 字符串的排列
 */
public class Permutation {
    /**
     * 递归，回溯，剪枝
     * 分两步：
     * 1. 固定一位，找剩余字符的排列
     * 2. 找该位的所有可能
     * @param s
     * @return
     */
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x) {
        if(x == c.length-1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = x; i < c.length; ++i) {
            if(set.contains(c[i])) //剪枝
                continue;
            set.add(c[i]);
            swap(x, i);
            dfs(x+1);
            swap(x, i); //回溯
        }
    }

    public void swap(int x, int y) {
        char temp = c[y];
        c[y] = c[x];
        c[x] = temp;
    }

    public static void main(String[] args) {
        String str = "abcd";
        String[] permutation = new Permutation().permutation(str);
        System.out.println(Arrays.toString(permutation));
    }
}
