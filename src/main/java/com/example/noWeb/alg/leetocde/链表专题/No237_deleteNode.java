package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No237_deleteNode {

    /**
     * 237. 删除链表中的节点 Easy
     *
     *  @param node 题目给的是删除节点，那说明这个节点可以舍弃了，我们把下一个节点的值拷贝给当前要删除的节点，再删除下一个节点。
     *               大致过程如下（删除3）：
     *               1->2->3->4->5
     *               1->2->4->4->5
     *               1->2->4->5
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
