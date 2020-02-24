package com.example.noWeb.alg.jianzhiOffer;


public class T50构建乘积数组_que {
    public static int[] multiply(int[] A) {
        if (A.length == 0) {
            return new int[1];
        }
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }
        for (int i = 0, p = 1; i < n; i++) {
            B[i] *= p;
            p *= A[i];
        }

        for (int i = n - 1, p = 1; i >= 0; i--) {
            B[i] *= p;
            p *= A[i];
        }
        return B;
    }

    public static int[] multiply2(int[] A) {
        if (A.length == 0) {
            return new int[1];
        }
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }
                B[i] *=A[j];
            }
        }

        return B;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        multiply2(arr);
    }
}