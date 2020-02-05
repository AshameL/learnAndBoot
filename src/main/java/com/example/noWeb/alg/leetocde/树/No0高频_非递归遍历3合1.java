package com.example.noWeb.alg.leetocde.树;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No0高频_非递归遍历3合1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<MyNode> stack = new Stack<>();
        if(root==null){
            return res;
        }
        MyNode current = new MyNode(0,root);
        stack.push(current);
        while (!stack.isEmpty()){
            MyNode myNode = stack.pop();
            int flag = myNode.flag;
            TreeNode node = myNode.node;

            if(flag==1){ // 如果遍历过了一次，那么就将val添加到res当中。
                res.add(node.val);
            }else {// 没遍历的时候
                //1. 因为栈的特性，所以先右后左。
                if(node.right!=null){
                    stack.push(new MyNode(0,node.right));
                }
                //2. 打上遍历的标记
                myNode.flag = 1;
                stack.push(myNode);
                //3. 左边进栈
                if(node.left!=null){
                    stack.push(new MyNode(0,node.left));
                }
            }
        }
        return res;
    }




     class MyNode {
         int flag;
         TreeNode node;
         MyNode(int flag, TreeNode node){
             this.flag = flag;
             this.node = node;
         }

    }

}
