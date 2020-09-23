package com.paulok777.expander;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack<T> {

    private final Deque<T> stack;

    public Stack() {
        stack = new ArrayDeque<>();
    }

    public T pop() {
        return stack.pop();
    }

    public void push(T value) {
        stack.push(value);
    }
}
