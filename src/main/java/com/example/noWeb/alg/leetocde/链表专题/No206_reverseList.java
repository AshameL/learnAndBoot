package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No206_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head,next,prev = null;
        while (current != null){
            // 记录后继结点
            next = current.next;
            // 后继指针逆向
            current.next = prev;
            // 记录当前节点
            prev = current;
            // 下一个结点成为当前节点 // 跟上面的一行不能调换嗷
            current = next;
        }
        return prev;
    }
}
