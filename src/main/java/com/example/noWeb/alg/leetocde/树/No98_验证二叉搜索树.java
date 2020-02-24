package com.example.noWeb.alg.leetocde.树;

import com.example.noWeb.alg.leetocde.TreeNode;

public class No98_验证二叉搜索树 {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;//
        }
        TreeNode left =root;
        while (left.left!=null){
            left = left.left;
        }
        pre = left;
        return isValid(root);

    }

    private boolean isValid(TreeNode root) {
        if(root==null) return true;
        if(!isValid(root.left)) return false;

        if(root!=pre && root.val<=pre.val) return false;
        pre = root;
        return isValid(root.right);
    }

}
