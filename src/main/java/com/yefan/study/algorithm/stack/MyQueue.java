package com.yefan.study.algorithm.stack;

import java.util.Stack;

/**
 * 栈实现队列
 */
public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        int2out();
        return out.pop();
    }

    public int peek() {
        int2out();
        return out.peek();
    }

    private void int2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean isEmpty() {
         return in.isEmpty() && out.isEmpty();
    }
}
