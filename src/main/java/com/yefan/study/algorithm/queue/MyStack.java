package com.yefan.study.algorithm.queue;

import java.util.Queue;

/**
 * 队列实现栈
 * @author yefan
 */
public class MyStack {
    private Queue<Integer> queue;

    public MyStack(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void push(int x) {
        queue.add(x);
        int length = queue.size();
        while(length > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
