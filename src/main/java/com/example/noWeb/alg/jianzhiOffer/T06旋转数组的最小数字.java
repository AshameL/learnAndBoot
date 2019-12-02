package com.example.noWeb.alg.jianzhiOffer;

import java.util.Stack;

public class T06旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        int t = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }
        return array[0];

    }
}
