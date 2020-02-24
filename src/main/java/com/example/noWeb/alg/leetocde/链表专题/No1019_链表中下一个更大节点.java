package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.ArrayList;
import java.util.Stack;


public class No1019_链表中下一个更大节点 {

    // 知识点：单调栈 可参考下面两个
    // https://leetcode-cn.com/problems/sliding-window-maximum/solution/dan-diao-di-jian-zhan-by-huangyt/
    // https://leetcode-cn.com/problems/maximum-width-ramp/solution/dan-diao-di-jian-zhan-on-by-huangyt/
    public int[] nextLargerNodes(ListNode head) {
        if(head==null)return null;
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (head!=null){
            arrayList.add(head.val);
            head=head.next;
        }

        Stack<Integer> stack=new Stack<>();
        int len=arrayList.size();
        int[] res=new int[len];
        for (int i=0;i<len;i++) {
            int num=arrayList.get(i);
            while (stack.size() > 0 && arrayList.get(stack.peek()) <num ) {
                Integer popIndex = stack.pop();
                res[popIndex] = num;
            }
            stack.push(i);
        }
        return res;

    }


}
