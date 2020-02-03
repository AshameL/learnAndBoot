package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;

public class T24_二叉树和为路径_imp {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath_Better(TreeNode root,int target){
        if(root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if(target==0&&root.left==null&&root.right==null){
            listAll.add(new ArrayList<>(list));
        }
        FindPath_Better(root.left,target);
        FindPath_Better(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }











    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return arr;
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        int sum = 0;
        pa(root, target, arr, a1, sum);
        return arr;
    }

    public void pa(TreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
        if (root == null)
            return;
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size() - 1);

            }
            return;

        }
        a1.add(root.val);
        pa(root.left, target, arr, a1, sum);
        pa(root.right, target, arr, a1, sum);
        a1.remove(a1.size() - 1);
    }
}
