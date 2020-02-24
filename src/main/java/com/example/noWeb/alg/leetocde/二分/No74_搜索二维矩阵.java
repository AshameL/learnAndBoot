package com.example.noWeb.alg.leetocde.二分;



public class No74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int n = matrix.length, m = matrix[0].length;
        int l = 0,r = n*m-1;

        while(l<r){
            int mid = (l+r)/2;
            if(matrix[mid/m][mid%m] >=target){
                r = mid;
            }else{
                l = mid +1;
            }
        }
        return matrix[r/m][r%m]==target;
    }
}
