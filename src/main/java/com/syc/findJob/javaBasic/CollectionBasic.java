package com.syc.findJob.javaBasic;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class CollectionBasic {

    public void customCompareSort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-5);
        list.add(3);
        list.add(1);
        list.add(4);
        System.out.println(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

    }

    public static void main(String[] args) {
        CollectionBasic collectionBasic = new CollectionBasic();
        collectionBasic.customCompareSort();
    }
}
