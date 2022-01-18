package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.Stack;

// Use Generics?

@Component
public class StackService {

    private Stack<Integer> stack = new Stack<>();

    public void push(Integer val) {
        stack.push(val);
    }

    public Integer pop() {
        return stack.pop();
    }

    public Integer get(int index) {
        return stack.get(index);
    }
}
