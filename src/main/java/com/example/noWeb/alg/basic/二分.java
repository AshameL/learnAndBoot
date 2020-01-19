package com.example.noWeb.alg.basic;

public class 二分 {

    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;  // 会溢出
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }

    }

    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        int middle = 0;

        if(key < arr[low] || key > arr[high] || low>high){
            return  -1;
        }
        while (low<=high){
            middle = (low+high)/2;
            if(arr[middle]>key){
                high = middle-1;
            }else if(arr[middle] <key){
                low = middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }

}
