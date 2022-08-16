package com.syc.findJob.jianzhiOffer;

public class Exist2 {
    int index;
    public boolean exist(char[][] board, String word) {
        //入参判断
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.trim().equals(""))
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(exist(board, m, n, i, j, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int m, int n, int i, int j, String word, boolean[][] visited) {
        if(index == word.length())
            return true;
        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;
        boolean hasNext = false;
        if(board[i][j] == word.charAt(index) && !visited[i][j] ) {
            ++index;
            visited[i][j] = true;
            hasNext = exist(board, m, n, i, j-1, word, visited)
                    || exist(board, m, n, i, j+1, word, visited)
                    || exist(board, m, n, i-1, j, word, visited)
                    || exist(board, m, n, i+1, j, word, visited);
            if(!hasNext) {
                --index;
                visited[i][j] = false;
            }
        }
        return hasNext;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new Exist2().exist(board, word));
    }
}
