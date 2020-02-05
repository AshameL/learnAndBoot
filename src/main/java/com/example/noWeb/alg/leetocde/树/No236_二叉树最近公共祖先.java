package com.example.noWeb.alg.leetocde.树;

import com.example.noWeb.alg.leetocde.TreeNode;

public class No236_二叉树最近公共祖先 {
    // 1. 递归方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;

        if(root==p||root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }else if(left !=null){
            return left;
        } else if(right!=null){
            return right;
        }
        return null;
    }
    // 2. 如果非递归呢？

}
