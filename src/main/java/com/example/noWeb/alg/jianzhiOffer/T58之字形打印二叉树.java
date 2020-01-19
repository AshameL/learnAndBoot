package com.example.noWeb.alg.jianzhiOffer;


import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.*;
import java.util.Queue;

public class T58之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return res;
        }
        ArrayList<Integer> list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int rows=1;
        queue.add(pRoot);
        while(!queue.isEmpty()){
            list = new ArrayList();
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode t = queue.poll();
                if(rows%2 ==0)
                    list.add(0,t.val);
                else
                    list.add(t.val);
                if(t.left!=null)
                    queue.offer(t.left);
                if(t.right!=null)
                    queue.offer(t.right);

            }
            res.add(list);
            rows++;
        }
        return res;
    }
}