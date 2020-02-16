package com.example.noWeb.alg.leetocde.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class No51_N皇后 {
    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] dia1;// 对角线1
    boolean[] dia2;// 对角线2

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        putQueen(n, 0, new ArrayList());
        return res;
    }

    /**
     * n:n个皇后
     * index：遍历到第n列
     * row：第index列上的行数组
     */
    void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后摆放在第 i 列上
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                // 回溯
                row.remove(row.size() - 1);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
            return;
        }

    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> board = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (row.get(i) == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        No51_N皇后 n1 = new No51_N皇后();
        System.out.println(n1.solveNQueens(4));
    }

}
