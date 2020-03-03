package com.example.noWeb;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.lang.reflect.Method;
import java.util.*;

public class Solution {
    public int pivotIndex(int[] nums) {

        int l = 0,r = nums.length-1;
        int sum1 = nums[l],sum2=nums[r];
        while(l<r){
            if(sum1<sum2){
                l++;
                sum1 +=nums[l];

            }else if(sum1 >sum2){
                r--;
                sum2 += nums[r];
            }else{
                if(r-l==2){
                    return l+1;
                }else{
                    l++;
                    r--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {1,2,3};
        int flag = solution.pivotIndex(nums);
        System.out.println(flag);
    }
}
