package com.syc.findJob.jianzhiOffer;

public class Exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        int index = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(hasPathCore(board,m,n,i,j,word,index,visited))
                    return true;
            }
        }

        return false;
    }

    public boolean hasPathCore(char[][] board, int m, int n, int i, int j,
                               String word, int index, boolean[][] visited) {
        if(index == word.length())
            return true;
        boolean hasPath = false;
        if(i >= 0 && j >= 0 && i < m && j < n && board[i][j] == word.charAt(index) && !visited[i][j]) {
            ++index;
            visited[i][j] = true;
            hasPath = hasPathCore(board,m,n,i-1,j,word,index, visited)
                    || hasPathCore(board,m,n,i+1,j,word,index, visited)
                    || hasPathCore(board,m,n,i,j-1,word,index, visited)
                    || hasPathCore(board,m,n,i,j+1,word,index, visited);
            if(!hasPath) {
//                --index;
                visited[i][j] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new Exist().exist(board, word));
    }
}
