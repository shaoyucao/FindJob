package com.syc.findJob.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        if(n < 1 || k < 1 || k > n) {
            return res;
        }

        combination(n, k, 1, new ArrayList<>());

        return res;

    }

    private void combination(int n, int k, int start, List<Integer> p) {
        if(p.size() == k) {
            res.add(new ArrayList<>(p));
            return;
        }

        // p中还剩下k-p.size()个空位，在[i...n]的范围内，i最多到几，能保证有k-p.size()个数
        for(int i = start; i <=n; i++) { //剪枝：i <= n - (k-p.size()) + 1
            p.add(i);
            combination(n, k, i+1, p);
            p.remove(p.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Combine().combine(4,2));
    }

}
