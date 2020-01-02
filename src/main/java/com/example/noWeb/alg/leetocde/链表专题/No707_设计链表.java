package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.HashSet;

public class No707_设计链表 {
    public Node head;
    public int size;

    //结点类
    private class Node{
        int val;
        Node next;
        public Node(){}
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    /** Initialize your data structure here. */
    // void 多余了！！！
    public void MyLinkedList() {
        head = new Node();
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0)return -1;
        Node p = head;
        int i = -1;
        while(i < index){
            p = p.next;
            i++;
        }
        return p.val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node p = head;
        int i = -1;
        if(index >= 0 && index <= size){
            Node node = new Node(val);
            if(index == 0){
                node.next = head.next;
                head.next = node;
            }else{
                while(i < index-1){
                    p = p.next;
                    i++;
                }
                node.next = p.next;
                p.next = node;
            }
            size++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= 0 && index < size){
            if(index == 0){
                head.next = head.next.next;
            }else{
                Node p = head;
                int i = -1;
                while(i < index - 1){
                    p = p.next;
                    i++;
                }
                p.next = p.next.next;
            }
            size--;
        }

    }

}
