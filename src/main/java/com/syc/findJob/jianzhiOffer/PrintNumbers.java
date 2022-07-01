package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintNumbers {
    public int[] printNumbers(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        if(n < 1)
            return new int[]{};

        for(int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            printNumbers(list, sb, 0, n);
        }

        int size = list.size();
        int[] res = new int[size-1];
        for(int i = 0; i < size-1; i++) {
            res[i] = list.get(i+1);
        }
        return res;
    }

    public void printNumbers(ArrayList<Integer> list, StringBuilder sb, int index, int n ) {
        if(index == n - 1) {
            list.add(strToInt(sb.toString()));
            return;
        }
        for(int i = 0; i < 10; i++) {
            sb.append(i);
            printNumbers(list, sb, index+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public int strToInt(String str) {
        if(null == str){
            return -1;
        }
        int len = str.length();

        boolean startWith0 = true;

        int res = 0;
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) != '0' ) {
                startWith0 = false;
            }
            if(!startWith0) {
                res += (str.charAt(i) - '0') * Math.pow(10, len-1-i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(n)));
    }
}
