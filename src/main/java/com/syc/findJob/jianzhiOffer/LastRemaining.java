package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining {
    public int lastRemaining(int n, int m) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            list.add(i);
        }

        int index = 0;
        while(n > 1) {
            index = (index + m -1) % n;
            list.remove(index);
            --n;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int n = 10, m = 17;
        int res = new LastRemaining().lastRemaining(n, m);
        System.out.println(res);
    }
}
