package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.RandomListNode;

public class T25_复杂链表的复制 {
    // 这题我不懂！！！！！！！1
    //https://www.nowcoder.com/profile/963880/codeBookDetail?submissionId=1512226
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode p=pHead;
        RandomListNode t=pHead;
        while (p!=null){
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;//???
            p.next = q;
            p = q.next;
        }
        while (t!=null){
            RandomListNode q = t.next;
            if(t.random!=null)
                q.random = t.random.next;
            t = q.next;
        }
        RandomListNode s = new RandomListNode(0);
        RandomListNode s1 = s;
        while(pHead!=null){
            RandomListNode  q=pHead.next;
            pHead.next=q.next;
            q.next=s.next;
            s.next=q;
            s=s.next;
            pHead=pHead.next;


        }
        return s1.next;
    }
}
