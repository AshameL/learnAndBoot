package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T63滑动窗口最大值 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size==0){
            return res;
        }
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            System.out.print("i "+i+" :");
            begin = i-size+1;
            if(q.isEmpty()){
                q.add(i);
            }else if(begin>q.peekFirst()){
                q.pollFirst();
            }

            while ((!q.isEmpty())&& num[q.peekLast()]<=num[i]){
                q.pollLast();
            }

            q.add(i);
            if(begin>=0){
                res.add(num[q.peekFirst()]);
            }
            System.out.println(q);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        maxInWindows(nums,size);
    }
}