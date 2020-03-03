package com.example.noWeb.alg.leetocde.双指针;

import java.util.HashMap;

public class No159_至多包含两个不同字符的最长字符串 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                count++;
            }
            right++;
            while (count > 2) {
                char temp = s.charAt(left);
                map.put(temp, map.get(temp) - 1) ;
                if (map.get(temp) == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
