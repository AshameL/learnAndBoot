package com.example.noWeb.alg.leetocde.递归回溯.排列基础题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47_全排列2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 1)
            return res;
        Arrays.sort(nums);
        helper(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            helper(cur, nums, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        No47_全排列2 hander = new No47_全排列2();
        Object obj = hander.permuteUnique(nums);
        System.out.println(obj);
    }

}
