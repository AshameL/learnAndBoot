package com.example.noWeb.alg.jianzhiOffer;


import com.example.noWeb.alg.leetocde.TreeNode;
import java.util.*;

/**
 *
 */
public class T18二叉树镜像 {
    public void Mirror(TreeNode root) {
        if(root==null)
            return ;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode t = s.pop();
            if(t.left!=null || t.right!=null){
                TreeNode tmp = t.left;
                t.left = t.right;
                t.right = tmp;
            }
            if(t.left !=null)
                s.push(t.left);
            if(t.right!=null)
                s.push(t.right);
        }

    }
    //  这个方法更好
    public void Mirror2(TreeNode root) {
        if(root==null)
            return ;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror2(root.left);
        Mirror2(root.right);
    }
}
