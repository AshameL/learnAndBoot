package com.example.noWeb.alg.jianzhiOffer;


public class T65机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows,cols,0,0,visited);

    }

    private int dfs(int threshold,int rows,int cols,int x,int y,boolean[][] visited){
        if(x<0|| x>=rows || y<0 || y>=cols)return 0;
        if(visited[x][y] || !checkSum(threshold,x,y)){
            return 0;
        }
        visited[x][y] = true;

        return 1+dfs(threshold,rows,cols,x,y+1,visited)
                +dfs(threshold,rows,cols,x,y-1,visited)
                +dfs(threshold,rows,cols,x-1,y,visited)
                +dfs(threshold,rows,cols,x+1,y,visited);
    }

    private boolean checkSum(int threshold,int row,int col){
        int sum = 0;
        while(row!=0){
            sum+= row%10;
            row /= 10;
        }
        while(col !=0){
            sum+=col%10;
            col /= 10;
        }
        return sum == threshold;
    }


//    public int movingCount(int threshold, int rows, int cols) {
//        boolean[] visited = new boolean[rows * cols];
//        return movingCountCore(threshold, rows, cols, 0, 0, visited);
//    }
//
//    private int movingCountCore(int threshold, int rows, int cols,
//                                int row, int col, boolean[] visited) {
//        if (row < 0 || row >= rows || col < 0 || col >= cols) {
//            return 0;
//        }
//        int i = row * cols + col;
//        if (visited[i] || !checkSum(threshold, row, col)) {
//            return 0;
//        }
//        visited[i] = true;
//        return 1 + movingCountCore(threshold, rows, cols, row, col + 1, visited)
//                + movingCountCore(threshold, rows, cols, row, col - 1, visited)
//                + movingCountCore(threshold, rows, cols, row + 1, col, visited)
//                + movingCountCore(threshold, rows, cols, row - 1, col, visited);
//    }
//
//    private boolean checkSum(int threshold, int row, int col) {
//        int sum = 0;
//        while (row != 0) {
//            sum += row % 10;
//            row = row / 10;
//        }
//        while (col != 0) {
//            sum += col % 10;
//            col = col / 10;
//        }
//        return sum <= threshold;
//    }
}