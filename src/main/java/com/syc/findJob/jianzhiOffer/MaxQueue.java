package com.syc.findJob.jianzhiOffer;

import java.util.LinkedList;

public class MaxQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> auxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        auxQueue = new LinkedList<>();
    }

    public int max_value() {
        if(auxQueue.isEmpty())
            return -1;
        return auxQueue.getFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while(!auxQueue.isEmpty() && value > auxQueue.getLast())
            auxQueue.removeLast();
        auxQueue.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int value = queue.removeFirst();
        if(value == auxQueue.getFirst()) {
            auxQueue.removeFirst();
        }
        return value;
    }
}
