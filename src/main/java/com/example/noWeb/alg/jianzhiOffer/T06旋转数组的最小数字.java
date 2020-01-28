package com.example.noWeb.alg.jianzhiOffer;

import java.util.Stack;

/**
 * 二分查找的变型。
 * 时间复杂度 logN级别。
 */
public class T06旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length-1;
        while (low<high){
            int mid = low+(high-low)/2;
            if(array[mid] > array[high]){
                low = mid+1;
            }else if(array[mid]==array[high]) {
                high = high-1;
            }else {
                high = mid;
            }
        }
        return array[low];
    }
}
