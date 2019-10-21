package com.example.learn.local.leetocde.链表专题;

import com.example.learn.local.leetocde.ListNode;

/**
 * 方法2：我觉得还可以用栈，不过题目好像不太建议。可是reverseList这个用到No206的基础，加油。
 */
public class No234_PalindromeList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //1.1此处到洗余下处是做一个slow 和fast指针，当遍历结束的时候，slow指向中部位置，fast指向尾部位置
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.1获取当前slow的下一个节点为mid节点，slow的next节点指向null，断开左右两部分
        ListNode mid = slow.next;
        slow.next = null;
        //2.2 右半部分的pre节点是mide，传入后翻转右半部分节点
        ListNode right = reverseList(mid);
        //3.1令left节点为左半部分的头节点，right为右半部分的头结点，比较值
        ListNode left = head;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head, next, prev = null;
        while (current != null) {
            // 记录后继结点
            next = current.next;
            // 后继指针逆向
            current.next = prev;
            // 记录当前结点
            prev = current;
            // 下一结点成为当前结点
            current = next;
        }
        return prev;
    }
}
