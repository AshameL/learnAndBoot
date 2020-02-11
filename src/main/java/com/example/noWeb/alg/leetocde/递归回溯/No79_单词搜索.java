package com.example.noWeb.alg.leetocde.递归回溯;

public class No79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i =0;i<r;i++){
            for(int j = 0;j<c;j++){
                if (dfs(board, word, 0, i, j,new boolean[r][c]))return true;
            }
        }
        return false;
    }

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean dfs(char[][] board, String word, int start, int xi, int yi, boolean[][] visited) {
        if (start == word.length() - 1) {
            return board[xi][yi] == word.charAt(start);
        }
        if (board[xi][yi] == word.charAt(start)) {
            visited[xi][yi] = true;
            int newX = 0, newY = 0;
            for (int i = 0; i < 4; i++) {
                newX = xi + d[i][0];
                newY = yi + d[i][1];

                // 如果下一动作的元素下标都是合法的
                if (inArray(newX, newY, board) && !visited[newX][newY]) {
                    if (dfs(board,word, start + 1, newX, newY, visited))return true;
                }
            }
            visited[xi][yi] = false;
        }
        return false;
    }

    private boolean inArray(int newX, int newY, char[][] board) {
        return newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length;
    }

    public static void main(String[] args) {
        No79_单词搜索 hander =new No79_单词搜索();
        char[][] board = {{'a','b'}};
        String word = "ba";
        Object obj = hander.exist(board,word);
        System.out.println(obj);
    }
}
