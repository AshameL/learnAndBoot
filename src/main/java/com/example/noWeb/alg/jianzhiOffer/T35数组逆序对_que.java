package com.example.noWeb.alg.jianzhiOffer;


public class T35数组逆序对_que {
    public int inversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
    // todo 撸一遍 归并排序
    int merge(int[] nums,int l,int r){
        if(l>=r) return 0;
        int mid = (l+r)/2;
        int res = merge(nums,l,mid) + merge(nums,mid+1,r);
        int i = l,j = mid+1;
        int[] temp = new int[nums.length];
        int p = 0;
        while (i<=mid && j<=r){
            if(nums[i]<=nums[j]){
                temp[p++]=nums[i++];
            }else{
                 temp[p++]= nums[j++];
                    res += mid-i+1;
            }
        }
        while (i<=mid){
            temp[p++] = nums[i++];
        }
        while (j<=r){
            temp[p++] = nums[j++];
        }

        return res;
    }
}