package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class T64矩阵中的路径 {
    boolean[][] vis;
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !vis[i][j]) {
                    vis[i][j] = true;
                    if (backtrack(board, word, i, j, 1)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int start) {
        if (start == word.length()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int x = row + dir[i][0];
            int y = col + dir[i][1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (!vis[x][y] && board[x][y] == word.charAt(start)) {
                    vis[x][y] = true;
                    if (backtrack(board, word, x, y, start + 1)) {
                        return true;
                    }
                    vis[x][y] = false;
                }

            }
        }
        return false;
    }


    public static void main(String[] args) {
        T64矩阵中的路径 t = new T64矩阵中的路径();
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
//        board  = new char[][]{{'a'}};
//        word = "a";
        Object obj = t.exist(board, word);
        System.out.println(obj);
    }
}