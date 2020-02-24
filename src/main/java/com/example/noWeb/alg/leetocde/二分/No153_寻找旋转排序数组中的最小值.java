package com.example.noWeb.alg.leetocde.二分;


/**
 * 重点题：
 * https://www.bilibili.com/video/av35162983?from=search&seid=11291062675150388072
 * 大雪菜 35:09
 * lc 153. Find Minimum in Rotated Sorted Array
 *
 */
public class No153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        int l = 0,r = nums.length-1;

        if(nums[0]<nums[r]) return nums[0];
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] >=nums[0]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[r] ;
    }
}
