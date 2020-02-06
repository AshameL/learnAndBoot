package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.List;

public class No39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates,0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates,int start, int target, ArrayList<Integer> current) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            current.add(candidates[i]);
            dfs(candidates, i,target - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        No39_组合总和 hander = new No39_组合总和();
        int[] candidates = {2, 3, 6, 7};
        Object object = hander.combinationSum(candidates, 7);
        System.out.println(object);
    }
}
