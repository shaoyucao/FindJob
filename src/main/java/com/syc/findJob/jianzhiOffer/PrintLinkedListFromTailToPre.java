package com.syc.findJob.jianzhiOffer;


import java.util.*;

public class PrintLinkedListFromTailToPre {

    public static void printLinkedListFromTailToPre(ListNode p) {
        LinkedList<ListNode> stack = new LinkedList<>();
        while(null != p) {
            stack.push(p);
            p = p.next;
        }

        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            System.out.println(top.val);
        }

    }

    public static void printLinkedListFromTailToPre2(ListNode p) {
        if(null != p){
            printLinkedListFromTailToPre2(p.next);
            System.out.println(p.val);
        }
    }

    //递归写法
    public static int[] printLinkedListFromTailToPre3(ListNode p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(null != p){
            printLinkedList(p, list);
        }
        //返回一个int流，如list.stream().mapToInt(x->x*2).forEach(System.out::println);
        //同理的，还有mapToLong(), mapToDouble()
        return list.stream().mapToInt(x->x).toArray();
    }

    public static void printLinkedList(ListNode p, ArrayList<Integer> list) {
        if(null != p) {
            printLinkedList(p.next, list);
            list.add(p.val);
        }
    }

    /**
     * 压栈写法
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(null != head) {
            stack.push(head);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            arr[i++] = stack.pop().val;
        }
        return arr;
    }

    /**
     * 高效写法
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        int index = 0;
        ListNode temp = head;
        while(null != temp) {
            temp = temp.next;
            index++;
        }
        int[] res = new int[index];
        temp = head;
        for(int i = index - 1; i >= 0; i--){
            res[i] = temp.val;
            temp = temp.next;
        }
        return  res;
    }


    public static void main(String[] args) {
        ListNode p1 = new ListNode(5);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        p1.next = p2;
        p2.next = p3;
        int[] res = printLinkedListFromTailToPre3(p1);
        System.out.println(Arrays.toString(res));

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(0);
        System.out.println(Arrays.toString(list.stream().mapToInt(x->x).toArray()));
    }

}
