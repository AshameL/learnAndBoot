package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;
import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class T04___重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode f(int[] pre, int preHead, int preTail, int[] in, int inHead, int inTail) {
        if (preHead > preTail || inHead > inTail) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preHead]);
        for (int i = inHead; i <= inTail; i++) {
            if (in[i] == pre[preHead]) {
                root.left = f(pre, preHead + 1, preHead + i - inHead, in, inHead, i - 1);
                root.right = f(pre, preHead + i - inHead + 1, preTail, in, i + 1, inTail);
            }
        }
        return root;
    }
}
