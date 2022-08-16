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
            //可以优化为只向右和向下两个方向
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
        int m = 38;
        int n = 15;
        int k = 9;
        System.out.println(new MovingCount().movingCount3(m,n,k));
    }

    /// review
    /**
     * 递归回溯，时间复杂度O(m*n), 空间复杂度O(m*n), 时间效率相对较高了
     */
    int count;
    public int movingCount2(int m, int n, int k) {
        if(m <= 0 || n <= 0 || k < 0)
            return 0;
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, 0, 0, k, visited);
        return count;
    }

    public void dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        if(i >= 0 && j >= 0 && i < m && j < n && getBitNumCount(i) + getBitNumCount(j) <= k && !visited[i][j]) {
            ++count;
            visited[i][j] = true;
            dfs(m, n, i, j+1, k, visited);
            dfs(m, n, i+1, j, k, visited);
        }
    }

    public int getBitNumCount(int num) {
        int sum = 0;
        while(num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public int movingCount3(int m, int n, int k) {
        if(m <= 0 || n <= 0 || k < 0)
            return 0;
        int count = 1;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == 0 && j == 0)
                    continue;
                if(getBitNumCount(i) + getBitNumCount(j) <= k) {
                    //这里的递推，必须考虑两个方向的情况，不能简单的用一个方向进行判断。
                    // 比如当i=9, j=8, 下一行为i=10, j=7, 两者加和不相等
                    if(i > 0)
                        visited[i][j] |= visited[i-1][j];
                    if(j > 0)
                        visited[i][j] |= visited[i][j-1];
//                    visited[i][j] |= (i > 0) ? visited[i-1][j] : visited[i][j-1];
                    if(visited[i][j]){
                        ++count;
                    }
                }
                //这里也不能直接break
//                else break;
            }
        }
        return count;
    }
}
