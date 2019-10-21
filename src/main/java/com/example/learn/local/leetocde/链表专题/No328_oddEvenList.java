package com.example.learn.local.leetocde.链表专题;

import com.example.learn.local.leetocde.ListNode;

public class No328_oddEvenList {

    /**
     * 从头开始遍历链表，并新建一个链表，遍历过程中隔一个结点就取出一个结点，把取出来的结点编号为偶数的结点尾插到新链表中，
     * 原链表剩下的都是索引为奇数的元素，再把两个链表拼接起来，就可以得到结果。
     * @param head
     * @return
     *  odd 奇数  ； even 偶数
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        // 记录第二段的起始
        ListNode evenHead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 前面分了两段链表，下面这句将两段合并起来。
        odd.next = evenHead;
        return head;
    }
}
