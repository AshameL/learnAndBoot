package com.example.noWeb.alg.leetocde.栈;

import java.util.Stack;

public class No316_去除重复字母 {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        StringBuffer sb = new StringBuffer();

        char[] chs = s.toCharArray();
        // 计算count的个数
        for (char c:chs){
            count[c-'a'] ++;
        }
        for(char c:chs){
            count[ c- 'a']--;
            if(used[c-'a']){
                continue;
            }
            while (sb.length()>0
            && sb.charAt(sb.length()-1)>c
            && count[sb.charAt(sb.length()-1)-'a']>0){

                used[sb.charAt(sb.length()-1)-'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
            used[c-'a'] = true;
        }
        return sb.toString();
    }
}
