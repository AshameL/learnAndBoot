package com.example.noWeb.alg.leetocde.树;

import com.example.noWeb.alg.leetocde.TreeNode;

public class No124_二叉树中最大路径 {

    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }
    int getMax(TreeNode root){
        if(root ==null)return 0;
        int left = Math.max(0,getMax(root.left));
        int right = Math.max(0,getMax(root.right));
        res = Math.max(res, root.val+left+right );
        return Math.max(left,right)+root.val;
    }
}
