package com.example.learn.local.leetocde.链表专题;

import com.example.learn.local.leetocde.ListNode;

public class No24_swapPairs {
    /**
     * 设 A 的长度为 a + c，B 的长度为 b + c，
     * 其中 c 为尾部公共部分长度，
     * 可知 a + c + b = b + c + a。
     *
     * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
     * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
     * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
     * 【此题有点像快慢指针的拿到环形链表】
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2){
            l1 =(l1== null)?headB:l1.next;
            l2 = (l2 == null)?headA:l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode anode1 = new ListNode(4);
        ListNode anode2 = new ListNode(1);

        ListNode bnode1 = new ListNode(5);
        ListNode bnode2 = new ListNode(0);
        ListNode bnode3 = new ListNode(1);

        ListNode cnode1 = new ListNode(8);
        ListNode cnode2 = new ListNode(4);
        ListNode cnode3 = new ListNode(5);

        anode1.next = anode2;
        anode2.next = cnode1;

        bnode1.next = bnode2;
        bnode2.next = bnode3;
        bnode3.next = cnode1;

        cnode1.next = cnode2;
        cnode2.next = cnode3;
        cnode3.next = null;

        No24_swapPairs handler = new No24_swapPairs();
        handler.getIntersectionNode(anode1, bnode1);
    }
}
