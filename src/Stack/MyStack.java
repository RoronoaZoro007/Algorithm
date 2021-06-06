package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

    Deque<Integer> inQueue;
    Deque<Integer> outQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (inQueue.isEmpty()) {
            outQueue.push(x);
            while (!inQueue.isEmpty()) {
                outQueue.push(inQueue.pop());
            }
        } else {
            inQueue.push(x);
            while (!outQueue.isEmpty()) {
                inQueue.push(outQueue.pop());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (outQueue.isEmpty()) {
            return inQueue.pop();
        } else {
            return outQueue.pop();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (outQueue.isEmpty()) {
            return inQueue.peek();
        } else {
            return outQueue.peek();
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}
