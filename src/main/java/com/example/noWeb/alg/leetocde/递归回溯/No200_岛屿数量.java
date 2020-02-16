package com.example.noWeb.alg.leetocde.递归回溯;

public class No200_岛屿数量 {
    private int res = 0;
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private  boolean[][] visited ;
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false){
                    dfs(grid, 0, 0);
                    res++;
                }


            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY,grid) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n;
    }


}
