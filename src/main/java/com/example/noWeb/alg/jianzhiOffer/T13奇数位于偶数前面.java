package com.example.noWeb.alg.jianzhiOffer;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class T13奇数位于偶数前面 {
    /**
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     */
    public void reOrderArray(int[] a) {
        if (a == null || a.length == 0)
            return;
        int i = 0, j;
        while (i < a.length) {
            // i 指向第一个奇数
            while (i < a.length && !isEven(a[i])) {
                i++;
            }
            j = i + 1;
            // j 指向第一个偶数
            while (j < a.length && isEven(a[j])) {
                j++;
            }
            if (j < a.length) {
                int tmp = a[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    a[j2 + 1] = a[j2];
                }
                a[i++] = tmp;
            } else {
                break;
            }
        }
    }

    boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }
}
