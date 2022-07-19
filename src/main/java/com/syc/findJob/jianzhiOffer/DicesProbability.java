package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class DicesProbability {
    int k = 6;
    public double[] dicesProbability(int n) {
        int sumTotal = k * n - n + 1;
        int[] probabilities = new int[sumTotal];
        for(int i = 1; i <= 6; ++i) {
            probability(n, n, i, probabilities);
        }
        double[] ret = new double[sumTotal];
        for(int i = 0; i < sumTotal; ++i) {
            ret[i] = probabilities[i] * 1.0 / Math.pow(k, n);
        }
        return ret;
    }

    public void probability(int base, int current, int sum, int[] probabilities) {
        if(current == 1) {
            probabilities[sum-base]++;
        }
        else{
            for(int i = 1; i <= 6; ++i) {
                probability(base, current-1, sum+i, probabilities);
            }
        }
    }

    public static void main(String[] args) {
        int n = 1;
        double[] ret = new DicesProbability().dicesProbability(n);
        System.out.println(Arrays.toString(ret));
    }
}
