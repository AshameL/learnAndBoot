package com.example.noWeb;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.lang.reflect.Method;
import java.util.*;

public class Solution {
    class myType {
        TreeNode root;
        boolean used;

        myType(TreeNode root, boolean used) {
            this.root = root;
            this.used = used;
        }

    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<myType> stack = new Stack<>();
        stack.push(new myType(root, false));

        while (!stack.isEmpty()) {
            myType mt = stack.pop();
            if (!mt.used) {
                mt.used = true;
                stack.push(mt);
            } else {
                // step 3 右
                if (mt.root.right != null) {
                    stack.push(new myType(mt.root.right, false));
                }
                // step 2 左
                if (mt.root.left != null) {
                    stack.push(new myType(mt.root.left, false));
                }
                // step 1 根
                res.add(mt.root.val);
            }
        }
        return res;
    }
}
