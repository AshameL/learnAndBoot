package com.example.noWeb.alg.leetocde.双指针;

import java.util.Arrays;

public class No611_有效三角形 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        for(int i = 0;i<n-2;i++){
            for(int j =i+1;j<n-1;j++){
                int k = n-1;
                while(j<k){
                    if(nums[i]+nums[j]>nums[k]){
                        res += k-j;
                        break;
                    }  else{
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
