package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40_组合总和2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> current, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > target) {
                return;
            }
//            if ( i>1 && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], current, i );
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        No40_组合总和2 handler = new No40_组合总和2();
        int[] candidates ={10,1,2,7,6,1,5};
        Object object = handler.combinationSum2(candidates,8);
        System.out.println(object);
    }

}
