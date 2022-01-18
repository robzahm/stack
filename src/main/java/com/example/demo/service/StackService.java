package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.EmptyStackException;

// Use Generics?

@Component
public class StackService {

    @AllArgsConstructor
    @Getter
    private class Node {
        private Integer value;
        private int index;
        private Node previous;
    }

    private Node currentNode =  null;

    public void push(Integer val) {
        if (currentNode == null) {
            currentNode = new Node(val, 0, null);
        }
        else {
            currentNode = new Node(val, currentNode.index + 1, currentNode);
        }
    }

    public Integer pop() {
        if (currentNode == null) {
            throw new EmptyStackException();
        }
        Integer returnVal = currentNode.getValue();

        currentNode = currentNode.getPrevious();

        return returnVal;
    }

    public Integer get(int index) {
        // Throw exception if index is OOB

        Node iteratorNode = currentNode;
        while (index < iteratorNode.getIndex()) {
            iteratorNode = iteratorNode.getPrevious();
        }
        return iteratorNode.getValue();
    }
}
