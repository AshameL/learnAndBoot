package com.example.noWeb.alg.leetocde.字符串;

public class No_最长公共子串 {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return  "";
        }
        int index = 0;
        boolean flag = true;
        for (; index < strs[0].length(); index++) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    flag=false;
                    break;
                }
                char c2 = strs[i].charAt(index);
                if (c != c2) {
                    flag=false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
//        String[] arr = {"flower", "flow", "flight"};
        String[] arr = {"dog","racecar","car"};
        String res = longestCommonPrefix(arr);
        System.out.println(res);
    }
}
