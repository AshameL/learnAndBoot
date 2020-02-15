package com.example.noWeb.alg.leetocde.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class No51_NQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(res, board, 0);
        return res;

    }

    private void helper(List<List<String>> res, char[][] board, int rowIndex) {
        if (rowIndex == board.length) {
            res.add(generate(board));
            return;
        }

        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if(isValid(board,rowIndex,colIndex)){
                board[rowIndex][colIndex] = 'Q';
                helper(res,board,rowIndex+1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    private List<String> generate(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c: row) {
                sb.append(c);
            }

            list.add(sb.toString());
        }

        return list;
    }


    private boolean isValid(char[][] board, int rowIndex, int colIndex) {
        for (int i = rowIndex - 1; i >= 0; i--) {
            if (board[i][colIndex] == 'Q') return false;
        }

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

}
