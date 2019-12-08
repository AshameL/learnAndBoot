package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;

/**
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *     2
 *   1    3
 *   变成 132
 */
public class T23后续遍历二叉树 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int count=sequence.length;
        if(count==0)
            return false;
        return isRight(sequence,0,count-1);

    }

    public boolean isRight(int[] sequence,int start,int end){
        if (start >= end) return true;
        int i = end - 1;// i是最后一个。
        // 找到i这个分界点的位置。
        while (sequence[i] > sequence[end] && i > start)
            i--;
        // 这样验证了左边是不是递增的。如果左边不递增那么i这个分界线找的不对 。
        for (int j = start; j < i; j++) {
            if (sequence[j] > sequence[end])
                return false;
        }
        return isRight(sequence, start, i) && isRight(sequence, i + 1, end - 1);
    }



}
