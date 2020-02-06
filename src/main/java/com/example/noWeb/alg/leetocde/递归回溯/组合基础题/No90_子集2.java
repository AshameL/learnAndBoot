package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90_子集2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new ArrayList<>(),nums,0);
        return res;
    }

    private void dfs(List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(cur,nums,index+1);
        cur.remove(cur.size()-1);

        while (index+1 <nums.length && nums[index]==nums[index+1]){
            index++;
        }
        dfs(cur,nums,index+1);
    }

    public static void main(String[] args) {
        No90_子集2 hand = new No90_子集2();
        int[] nums = {1,2,2};
        Object obj = hand.subsetsWithDup(nums);
        System.out.println(obj);
    }
}
