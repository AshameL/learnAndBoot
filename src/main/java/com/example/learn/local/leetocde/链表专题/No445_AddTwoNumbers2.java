package com.example.learn.local.leetocde.链表专题;

import com.example.learn.local.leetocde.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 由于计算时要保证最右边的数对齐，那么很自然的想到先用 栈 存放链表中的每个值，然后依次计算。
 * 由于相加时可能产生进位，所以使用一个carried 表示是否有进位，
 * s1 存储l1的节点，s2-->l2,result 是相加后的，carried进位
 */
public class No445_AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;

        }
        Stack<ListNode> s1= new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<ListNode> res = new Stack<>();

        while (l1 !=null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 !=null){
            s2.push(l2);
            l2 = l2.next;
        }
        int carried = 0;
        while (!s1.isEmpty() || !s2.isEmpty()){
            int sum = carried;
            if(!s1.isEmpty()){
                sum += s1.pop().val;
            }
            if(!s2.isEmpty()){
                sum += s2.pop().val;
            }
            carried = sum/10;
            sum %= 10;
            res.push(new ListNode(sum));

        }
        // 判断最后一位是否还有个进位
        if(carried != 0){
            res.push(new ListNode(carried));
        }

        ListNode node = new ListNode(-1);
        ListNode dummy = node;
        while (!res.isEmpty()){
            node.next = res.pop();
            node=node.next;
        }
        // 返回头节点
        return dummy.next;
    }
}
