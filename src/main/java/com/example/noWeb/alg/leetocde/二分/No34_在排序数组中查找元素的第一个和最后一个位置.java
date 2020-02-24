package com.example.noWeb.alg.leetocde.二分;


/**
 * 重点题：
 * https://www.bilibili.com/video/av35162983?from=search&seid=11291062675150388072
 * 大雪菜 22分钟。对二分找不大于的最小值，不小于的最大值。
 *
 */
public class No34_在排序数组中查找元素的第一个和最后一个位置 {

        public int[] searchRange(int[] nums, int target) {
            int[] res = {-1,-1};
            int l =0,r = nums.length-1;
            while(l<r){
                int mid = (l+r)/2;
                if(nums[mid] >=target)
                    r = mid;
                else {
                    l = mid +1;
                }

            }

            if(nums[r] != target) return res;
            res[0] =r;

            l=0;
            r = nums.length-1;
            while(l<r){
                int mid = (l+r+1)/2;
                if(nums[mid]<=target) l = mid;
                else
                    r = mid -1;
            }
            res[1] = r;
            return res;
        }

}
