package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;
import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class T04重建二叉树_imp {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode f(int[] pre, int preHead, int preTail, int[] in, int inHead, int inTail) {
        // 递归先写终止条件
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preorder.length - 1 || inLeft > inRight) return null;
        int pos = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (preorder[preLeft] == inorder[i]) {
                pos = i;
                System.out.println(pos);
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = build(preorder, preLeft + 1, preLeft + pos - inLeft, inorder, inLeft, pos - 1);
        root.right = build(preorder, preLeft + pos - inLeft + 1, preRight, inorder, pos + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        T04重建二叉树_imp t = new T04重建二叉树_imp();
        t.buildTree(preorder, inorder);
    }
}
