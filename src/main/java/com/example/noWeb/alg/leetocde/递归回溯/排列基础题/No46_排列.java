package com.example.noWeb.alg.leetocde.递归回溯.排列基础题;

import java.util.ArrayList;
import java.util.List;

public class No46_排列 {
    List<List<Integer>> res  = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        dfs(current,nums,used );
        return res;
    }

    private void dfs(List<Integer> current, int[] nums, boolean[] used) {
        if(current.size()==nums.length){
             res.add(new ArrayList<>(current) );
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(used[i]==false){
                used[i] = true;
                current.add(nums[i]);
                dfs(current,nums,used);
                current.remove(current.size()-1);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        No46_排列 handler = new No46_排列();
        List list = handler.permute(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
