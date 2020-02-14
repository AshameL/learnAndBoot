package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class T64矩阵中的路径 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0 || matrix.length != rows * cols || rows <= 0 || cols <= 0 || rows * cols < str.length) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int pathLength =0;

        for (int i = 0; i <= rows - 1; i++) {
            for (int j = 0; j <= cols - 1; j++) {
                if (hasPathCore(matrix, rows, cols, str, i, j, visited, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col,
                               boolean[] visited, int pathLength) {
        boolean flag = false;

        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && !visited[row * cols + col]
                && matrix[row * cols + col] == str[pathLength]) {
            pathLength++;
            visited[row * cols + col] = true;
            if (pathLength == str.length) {
                return true;
            }
            flag = hasPathCore(matrix, rows, cols, str, row, col + 1, visited, pathLength) ||
                    hasPathCore(matrix, rows, cols, str, row + 1, col, visited, pathLength) ||
                    hasPathCore(matrix, rows, cols, str, row, col - 1, visited, pathLength) ||
                    hasPathCore(matrix, rows, cols, str, row - 1, col, visited, pathLength);

            if (!flag) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }

        return flag;
    }
}