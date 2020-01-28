package com.example.noWeb.alg.jianzhiOffer;


import com.example.noWeb.alg.leetocde.TreeNode;

public class T61二叉搜索树的第k个结点 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        TreeNode[] result = new TreeNode[1];
        KthNode(pRoot, k, new int[1], result);
        return result[0];
    }

    private void KthNode(TreeNode pRoot, int k, int[] count, TreeNode[] result) {
        if (result[0] != null || pRoot == null) {
            return;
        }
        KthNode(pRoot.left, k, count, result);
        count[0]++;
        if(count[0]==k){
            result[0] = pRoot;
        }
        KthNode(pRoot.right,k,count,result);
    }

}