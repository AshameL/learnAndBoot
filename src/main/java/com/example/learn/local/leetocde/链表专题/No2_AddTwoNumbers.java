package com.example.learn.local.leetocde.链表专题;

import com.example.learn.local.leetocde.ListNode;

public class No2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1,p2 = l2;
        ListNode r1 = new ListNode(0);
        ListNode res = r1;
        int addPoint = 0;
        while (p1!=null || p2!=null || addPoint!=0 ){
            int sum = 0;
            sum += addPoint;
            addPoint = 0;

            if( p1 !=null){
                sum += p1.val;
                p1 = p1.next;
            }

            if( p2 !=null){
                sum += p2.val;
                p2 = p2.next;
            }

            if(sum>9){
                addPoint = 1;
                sum -= 10;
            }
            ListNode n = new ListNode(sum);
            r1.next = n;

            r1 = r1.next;


        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l2.next = l4;
        l4.next = l3;

        l5.next = l6;
        l6.next = l7;

        ListNode res = addTwoNumbers(l2,l5);
        while (res !=null){
            System.out.print(res.val+"->");
            res = res.next;
        }
    }

}
