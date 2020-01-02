package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.HashSet;

public class No817_链表组件 {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for(int x:G){
            set.add(x);
        }

        ListNode cur = head;
        int ans = 0;

        while (cur!=null){
            if(set.contains(cur.val)
                    && (cur.next == null|| !set.contains(cur.next.val))){
                ans++;
            }
            cur = cur.next;

        }
        return ans;

    }

}
