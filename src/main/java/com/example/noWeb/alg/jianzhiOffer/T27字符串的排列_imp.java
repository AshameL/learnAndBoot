package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.*;


public class T27字符串的排列_imp {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }


    private void swap(char[] chars, int a, int b) {
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
    }

}
