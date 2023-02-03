package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;
import java.util.Collections;

public class DicesProbability_Review {
    public double[] dicesProbability(int n) {
        double[] ret = new double[5*n+1];
        double total = Math.pow(6,n);
        for(int i = n; i <= 6*n; ++i) {
            ret[i-n] = (double) (i-n+2)*(i-n+1)/2.0/total;
        }
        return ret;
    }

    public static void main(String[] args) {
        DicesProbability_Review dicesProbability_review = new DicesProbability_Review();
        double[] res = dicesProbability_review.dicesProbability(3);
        System.out.println(Arrays.toString(res));
    }
}
