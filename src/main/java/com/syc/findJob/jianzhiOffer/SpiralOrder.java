package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class SpiralOrder {

    int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if(null == matrix)
            return new int[0];
        int rows = matrix.length;
        if(rows == 0)
            return new int[0];
        int columns = matrix[0].length;

        int[] ret = new int[rows * columns];

        if(rows <= 0 || columns <= 0)
            return new int[0];

        int start = 0;
        while(rows > start * 2 && columns > start * 2){
            printNumbers(matrix, rows, columns, start, ret);
            ++start;
        }

        return ret;
    }

    public void printNumbers(int[][] matrix, int rows, int columns, int start, int[] ret) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左向右打印是必须有的
        for(int i = start; i <= endX; ++i) {
            ret[index++] = matrix[start][i];
        }

        //从上到下打印的条件是至少有两行
        if(endY > start) {
            for(int i = start+1; i <= endY; i++) {
                ret[index++] = matrix[i][endX];
            }
        }

        //从右到左打印的条件是至少有两行两列
        if(endX > start && endY > start) {
            for(int i = endX-1; i >= start; i--) {
                ret[index++] = matrix[endY][i];
            }
        }

        //从下到上打印的条件是至少有三行两列
        if(endX > start && endY > start+1) {
            for(int i = endY-1; i > start; i--) {
                ret[index++] = matrix[i][start];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] ret = new SpiralOrder().spiralOrder(matrix);
        System.out.println(Arrays.toString(ret));
    }

}
