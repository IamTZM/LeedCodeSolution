package Queue;

import java.util.LinkedList;
import java.util.Deque;

/**
 * 225. Implement Stack using Queues
 */
public class Solution225 {
}

class MyStack {

    private Deque<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return q.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
