package com.example.noWeb.alg.leetocde;

import java.util.HashMap;
import java.util.Map;

public class No1_2sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null||nums.length==1)return res;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            int val = target - num;
            if(map.containsKey(val)){
                res[0]=i;
                res[1] = map.get(val);
            }else {
                map.put(num,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
