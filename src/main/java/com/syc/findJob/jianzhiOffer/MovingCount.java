package com.syc.findJob.jianzhiOffer;

public class MovingCount {
    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];

        int res = move(m, n, 0, 0, k, visited);


        return res;
    }

    public int move(int m, int n, int i, int j, int k, boolean[][] visited) {
        int count = 0;

        if(i >= 0 && j >= 0 && i < m && j < n && !visited[i][j] && countNums(i) + countNums(j) <= k) {
            ++count;
            visited[i][j] = true;
            //可以优化为只向右和向左两个方向
            count += move(m, n, i-1, j, k, visited) + move(m, n, i+1, j, k, visited) + move(m, n, i, j-1, k, visited) + move(m, n, i, j+1, k, visited);
        }

        return count;
    }

    public int countNums(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        System.out.println(new MovingCount().movingCount(m,n,k));
    }
}
