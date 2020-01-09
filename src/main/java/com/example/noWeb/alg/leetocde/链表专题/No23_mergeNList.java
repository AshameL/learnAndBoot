package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No23_mergeNList {

    /**
     * 方法1
     * 遍历所有链表，将所有节点的值放到一个数组中。
     * 将这个数组排序，然后遍历所有元素得到正确顺序的值。
     * 用遍历得到的值，创建一个新的有序链表
     */
    public ListNode mergeKLists_force(ListNode[] lists) {
        return null;
    }

    /**
     * 方法2
     * 使用最小堆 priority_queue
     * 因为每个子链表都排序过了，所以指针指向链表最前面的元素。从其中取出的最小的肯定是所有元素中最小的。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists_queue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode phead = head;

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            phead.next = temp;

            phead = phead.next;

            if (temp.next != null) {
                priorityQueue.offer(temp.next);
            }
        }

        return head.next;
    }

    /**
     * 方法3
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        if (len == 1) {
            return lists[0];
        }
        //二分 进行链表的两两组合
        while (len > 1) {
            int mid = (len + 1) / 2; // 二分
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i],lists[i+mid]);
            }
            len = mid;
        }
        return lists[0];
    }
    private ListNode mergeTwoLists(ListNode L1,ListNode L2){
        if(L1==null) {
            return L2;
        }
        if(L2==null) {
            return L1;
        }

        ListNode head = new ListNode(0);
        ListNode phead = head;

        while (L1!=null&&L2!=null){
            if(L1.val<=L2.val){
                phead.next = L1;
                phead = phead.next;
                L1 = L1.next;
            }else {
                phead.next = L2;
                phead = phead.next;
                L2= L2.next;
            }
        }
        if(L1!=null){
            phead.next = L1;
        }
        if(L2!=null){
            phead.next = L2;
        }
        return head.next;
    }

    public ListNode mergeKLists_heap(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq= new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode list:lists){
            if(list == null){
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()){
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            //
            if(nextNode.next!=null){
                pq.add(nextNode.next);
            }
        }
        return  dummyHead.next;
    }

}



