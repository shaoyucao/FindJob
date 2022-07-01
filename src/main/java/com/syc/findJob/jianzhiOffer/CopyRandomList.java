package com.syc.findJob.jianzhiOffer;

import java.util.HashMap;

public class CopyRandomList {

    //方法2：空间换时间法，回溯+哈希表
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(null == head)
            return null;

        //随机节点可能已经创建，也可能没有创建，因此需要用map缓冲
        if(!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    //方法3：多步拆解法
    public Node copyRandomList3(Node head) {
        if(null == head)
            return null;

        insertNodes(head);
        connectRandomNodes(head);
        return getNewNodes(head);
    }

    //复制复杂链表的第一步，把N'插入在N之后
    public void insertNodes(Node head) {
        Node cur = head;
        while(cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }

    //第二步，原先指向的随机节点N为现在所指向的随机节点N'
    public void connectRandomNodes(Node head) {
        Node cur = head;
        while(cur != null) {
            Node randN = cur.random;
            if(null == randN){
                cur.next.random = null;
            }else{
                cur.next.random = randN.next;
            }
            cur = cur.next.next;
        }
    }

    //第三步，将奇偶节点拆分成两串节点
    public Node getNewNodes(Node head) {
        Node n1 = head;
        Node n2 = head.next;

        Node newHead = n2;

        while(n1 != null) {
            n1.next = n2.next;
            n2.next = n1.next == null ? null : n1.next.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        return newHead;
    }

}
