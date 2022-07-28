package com.syc.findJob.jianzhiOffer;

/**
 * 二维数组中的查找
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
//        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};

        int[][] arr = {{-5}};
//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//
//        }
        System.out.println(findNumberIn2DArray2(arr, -5));
    }

    //首次打算按照直接查找的方式进行查询
    //错误的思路
    public static boolean findNumberIn2DArray(int[][] arr, int target) {
        if(null == arr || arr.length == 0 || arr[0].length == 0)
            return false;
        int n = arr.length;
        int m = arr[0].length;
        int j = 0;
        for(int i = 0; i < n; i++) {
            //往下遍历的时候记得对j进行范围控制
            if(j == m)
                j--;
            for( ; j < m; j++) {
                if(j < 0)
                    return false;
                if(arr[i][j] == target) {
                    return true;
                }
                else if (arr[i][j] < target) {
                    continue;
                }
                else if(arr[i][j] > target) {
                    --i;
                    --j;
                    break;
                }
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] arr, int target){
        if(null == arr || arr.length == 0 || arr[0].length == 0)
            return false;
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = m - 1; j >= 0; j--) {
                if(arr[i][j] == target) {
                    return true;
                }
                if(arr[i][j] > target) {
                    continue;
                }
                if(arr[i][j] < target) {
                    break;
                }
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = m - 1; j >= 0; j--) { //注意，这里是j>=0，不是j>0
                if(matrix[i][j] == target) {
                    return true;
                }
                if(matrix[i][j] > target) {
                    continue;
                }
                if(matrix[i][j] < target) {
                    break;
                }
            }
        }
        return false;
    }

    ///////// review

    /**
     * 时间O(n^2)， 空间O(1)
     * 暴力扫描
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray2_1(int[][] matrix, int target){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    /**
     * 时间O(m+n), 空间O(1)
     * 利用矩阵规律，从右上角（或者左下角）的元素开始查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray2_2(int[][] matrix, int target){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0) {
            if(target == matrix[i][j])
                return true;
            if(target < matrix[i][j])
                --j;
            else
                ++i;
        }
        return false;
    }
}
