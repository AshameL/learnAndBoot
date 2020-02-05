package com.example.noWeb.alg.leetocde.树;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No0高频_完全二叉树的最后一个结点 {
    // 方法一：层序遍历，输出最后一个。
    // O(n) 比较笨
    public TreeNode getLastNode(TreeNode root) {
        if(root==null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = null;
        while (queue.isEmpty()==false){
            TreeNode head = queue.poll();
            if(head.left!=null){
                queue.add(head.left);
            }
            if(head.right!=null){
                queue.add(head.right);
            }
        }
        last = queue.getLast();
        return last;
    }

    /**
     * 递归遍历左右子树，左子树深度大于右子树就遍历左子树，反之亦然。
     * @param root
     * @return
     */
    public TreeNode getLastNode_method2(TreeNode root) {
        if(root!=null && root.left==null){
            return root;
        }
        int leftHeight = 0;//左子树高度
        TreeNode node = root.left;
        while (node!=null){
            node = node.left;
            leftHeight++;
        }

        int rightHeight = 0;//右子树高度
        node = root.right;
        while (node!=null){
            node = node.left;// 也是左边！
            rightHeight++;
        }
        if(leftHeight > rightHeight){
            return getLastNode_method2(root.left);
        }else {
            return getLastNode_method2(root.right);
        }

    }
}
