package com.example.noWeb.alg.leetocde.二分;

import java.util.Arrays;

public class No162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        if(nums.length ==1 || nums[0]>nums[1]) return 0;

        int l = 1,r = nums.length-1;
        while(l<r){
            int mid = (l+r+1)/2;
            if(nums[mid]>nums[mid-1]){
                l = mid;
            }else{
                r = mid-1;
            }


        }
        return r;
    }
}
