package com.example.noWeb.alg.jianzhiOffer;


import java.util.Arrays;
import java.util.List;

public class T44扑克牌顺子NULL {
    public boolean isContinuous(int[] numbers) {
        Arrays.sort(numbers);
        int start = 0;
        int len = numbers.length;
        while (numbers[start] == 0) {
            start++;
        }
        if (start > 1) {
            return false;// 超过2个王了。
        }
        if (numbers[len - 1] - numbers[start] >= 5) {
            return false; // 两端极值超过5
        }
        for (int i = start; i < len-1; i++) {
            if(numbers[i]==numbers[i+1]){
                return false;
            }
        }
        return true;
    }
}