package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.List;

public class No77_组合 {
    // 优化：剪枝！！！！！！！！！
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n<=0||k<=0|| k>n){
            return res;
        }
        dfs(new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void dfs(ArrayList<Integer> current, int start, int n, int k) {


        if (current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }
        // 剪枝： i<= n-(k-c.size() +1
        for (int i = start; i <= n; i++) {
            current.add(i);
            dfs(current, i + 1, n, k );
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        No77_组合 handler = new No77_组合();
        Object obj = handler.combine(4,2);
        System.out.println(obj);
    }
}
