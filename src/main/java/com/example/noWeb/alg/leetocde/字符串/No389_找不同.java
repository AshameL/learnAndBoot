package com.example.noWeb.alg.leetocde.字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class No389_找不同 {
    public char findTheDifference(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();

        char c = char2[0];
        for(int i=0;i<char1.length;i++){
            c^= char1[i];
            c^=char2[i+1];
        }
        return c;
    }
}
