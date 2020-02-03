package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public class T22从上向下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> node = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        node.add(root);
        list.add(root.val);

        int i = 0;
        while (i < node.size()) {
            TreeNode t = node.get(i);
            if (t.left != null) {
                node.add(t.left);
                list.add(t.left.val);
            }
            if (t.right != null) {
                node.add(t.right);
                list.add(t.right.val);
            }
            i++;
        }
        return list;
    }

    public ArrayList<Integer> PrintFromTopToBottom_1(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove(queue.size() - 1);
            res.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return res;
    }
}
