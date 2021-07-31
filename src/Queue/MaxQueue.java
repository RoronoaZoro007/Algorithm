package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> realQueue;

    //维持一个降序序列；
    //从头到尾是降序的
    private Deque<Integer> maxQueue;

    public MaxQueue() {
        realQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        //如果当前元素比降序队列末尾的元素要大，那么末尾元素不会影响后序最大值，可以出队
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
        realQueue.add(value);
    }

    //如果出的元素和最大的元素相同，那么最大元素队列也要出队
    public int pop_front() {
        if (realQueue.isEmpty()) {
            return -1;
        }
        int val = realQueue.poll();
        if (val == maxQueue.peekFirst()) {
            maxQueue.pollFirst();
        }
        return val;
    }
}
