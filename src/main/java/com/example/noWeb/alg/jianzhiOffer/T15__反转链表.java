package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;

/**
 * 背下来啊！！！！！！
 */
public class T15__反转链表 {
    public ListNode ReverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while (head != null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转(next 已经移动好了)
            pre = head;
            // 向下滑动
            head = next;

        }
        return pre;
    }
    public ListNode ReverseListCommon(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode reHead = ReverseListCommon(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }
}
