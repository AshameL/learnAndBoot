package com.example.noWeb.alg.leetocde.堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No378_有序矩阵中第K小 {
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((n1,n2)->n2-n1 );
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                priorityQueue.add( matrix[i][j]);
                if(priorityQueue.size()>k){
                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
//        int[][] matrix = {{-5}};
//        int k = 1;
        int k = 8;
        int res = kthSmallest(matrix,k);
        System.out.println(res);
    }
}
