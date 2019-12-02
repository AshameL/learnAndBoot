package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;
import com.example.noWeb.alg.leetocde.TreeNode;

/**
 *
 */
public class T17____树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null|| root1==null){
            return false;
        }
        // 这一步太关键了！！！
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;

        if(root1.val != root2.val)
            return false;

        return isSubtreeWithRoot(root1.left,root2.left) && isSubtreeWithRoot(root1.right,root2.right);
    }
}
