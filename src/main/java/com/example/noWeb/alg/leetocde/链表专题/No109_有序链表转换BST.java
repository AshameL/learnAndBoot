package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;
import com.example.noWeb.alg.leetocde.TreeNode;

public class No109_有序链表转换BST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode mid = this.findMiddleElement(head);

        TreeNode node = new TreeNode(mid.val);
        if(head == mid){
            return node;
        }

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr!=null&&fastPtr.next!=null){
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if(prevPtr!=null){
            prevPtr.next = null;
        }
        return slowPtr;

    }

    /////////////////////////////////////////
    public TreeNode sortedListToBST_1(ListNode head ) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // p 一次前进一格，q 前进两格，pre 是 p 前一个
        ListNode p = head.next, q = head.next.next, pre = head;

        while (q != null && q.next != null) {
            pre = pre.next;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        // 链表被分成三段，再递归构造
        TreeNode root = new TreeNode(p.val);

        root.left  = sortedListToBST_1(head);

        root.right = sortedListToBST_1(p.next);

        return root;

    }
}
