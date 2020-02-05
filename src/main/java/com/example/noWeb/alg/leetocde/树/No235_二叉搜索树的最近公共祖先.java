package com.example.noWeb.alg.leetocde.树;

import com.example.noWeb.alg.leetocde.TreeNode;

public class No235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null|| q==null){
            return null;
        }

        if(root.val > p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val <p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
