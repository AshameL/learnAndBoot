package com.example.noWeb.alg.leetocde.字符串;

import java.util.Arrays;
import java.util.Comparator;

public class No179_最大数 {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if ((s1 + s2).compareTo(s2 + s1) > 0) {
                    return -1;
                } else if ((s1 + s2).compareTo(s2 + s1) < 0) {
                    return 1;
                } else if ((s1 + s2).compareTo(s2 + s1) == 0) {
                    return 0;
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        for (String i : strNums) {
            res.append(i);
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }
}
