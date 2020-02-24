package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90_子集2 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList();
        dfs(nums, 0, current, visited);

        return res;
    }


    public void dfs(int[] nums, int index, List<Integer> current, boolean[] visited) {
        if (nums.length == index) {
            res.add(new ArrayList(current));
            return;
        }

        if (index == 0 || nums[index - 1] != nums[index] || visited[index - 1]) {
            visited[index] = true;
            current.add(nums[index]);
            dfs(nums, index + 1, current, visited);
            current.remove(current.size() - 1);
            visited[index] = false;
        }


        dfs(nums, index + 1, current, visited);


    }
}
