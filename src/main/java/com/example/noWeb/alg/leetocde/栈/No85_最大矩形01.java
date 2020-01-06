package com.example.noWeb.alg.leetocde.栈;

import java.util.Stack;

public class No85_最大矩形01 {

    // 单调栈，递增栈。参考84，当然不一定是最优解法
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] grid = new int[row][col];
        buildHistogram(matrix, grid);

        int max = 0;
        for (int i = 0; i < row; i++) {
            max = Math.max(max, maxRec(grid[i]));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                grid[i][j] = matrix[i][j] == '1' ? grid[i - 1][j] + 1 : 0;
            }
        }
    }

    private int maxRec(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            while (stack.peek() != -1 && array[stack.peek()] > array[i]) {
                int height = array[stack.pop()];
                int disc = i - stack.peek() - 1;
                max = Math.max(max, height * disc);
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            max = Math.max(max,array[stack.pop()]*(array.length- stack.peek()-1));
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] chars = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        No85_最大矩形01 n = new No85_最大矩形01();
        int max = n.maximalRectangle(chars);
        System.out.println(max);
    }
}
