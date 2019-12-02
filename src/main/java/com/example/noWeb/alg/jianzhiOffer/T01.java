package com.example.noWeb.alg.jianzhiOffer;

public class T01 {
    public boolean Find(int target, int[][] array) {
        int rowSize = array.length;
        int colSize = array[0].length;
        int i = 0, j = colSize - 1;
        while (i<rowSize && j>=0) {

            if(target == array[i][j]){
                return true;
            }else if(target > array[i][j]){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        T01 t = new T01();
//        t.Find();
    }
}
