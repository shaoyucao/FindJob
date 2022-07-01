package com.syc.findJob.leetCode;

import java.util.Arrays;

public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {

        int count = 0;

        if(null == g || null == s || g.length == 0 || s.length == 0)
            return count;

        Arrays.sort(g);
        Arrays.sort(s);

        int index = g.length - 1, j = s.length - 1;
        while(j >= 0 && index >= 0) {
            int i = index;
            for( ; i >= 0; i--){
                if(s[j] >= g[i]){
                    count++;
                    index = i - 1;
                    break;
                }
            }
            if(s[j] < g[0])
                break;
            j--;
        }

        return count;
    }


    public int findContentChildren2(int[] g, int[] s) {
        int count = 0;

        if(null == g || null == s || g.length == 0 || s.length == 0)
            return count;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1, j = s.length - 1;

        while(j >= 0 && i >= 0) {
            if(s[j] >= g[i]) {
                j--;
                count++;
                i--;
            }else{
                i--;
            }
        }

        return count;

    }
    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};

        System.out.println(new FindContentChildren().findContentChildren(g,s));
    }

}
