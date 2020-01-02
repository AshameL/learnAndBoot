package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;
import com.example.noWeb.alg.leetocde.Node;
import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.HashMap;

public class No138_复制带随机指针的链表 {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        if(visitedHash.containsKey(head)){
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val,null,null);

        this.visitedHash.put(head,node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
