package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.List;

public class No78_子集 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        dfs(new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(cur, nums, index + 1);
        cur.remove(cur.size() - 1);
        dfs(cur, nums, index + 1);
    }

    public static void main(String[] args) {
        No78_子集 handler = new No78_子集();
        int[] nums = {1, 2, 3};
        Object object = handler.subsets(nums);
        System.out.println(object);
    }
}
