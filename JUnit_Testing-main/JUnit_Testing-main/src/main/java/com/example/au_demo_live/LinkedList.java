package com.example.au_demo_live;

public class LinkedList <T> {
    private Node<T> headNode;


    public T getElement(int index) {
        if (index < 0) {
            throw new RuntimeException("Index cannot be negative");
        }
        var iteratorNode = headNode;
        var currIndex = 0;
        while (iteratorNode != null) {
            if (currIndex == index) {
                return iteratorNode.getValue();

            }
            iteratorNode = iteratorNode.getNextNode();
            currIndex++;

        }
        throw new RuntimeException("index greater");
    }

    public void addElement(T element) {

        if(element==null){
            throw new RuntimeException("null value");
        }
        final var temp = new Node<T>();
        temp.setValue(element);
        if (headNode == null) {
            headNode = temp;
            return;
        }
        var iteratorNode = headNode;
        while (iteratorNode.getNextNode() != null) {
            iteratorNode = iteratorNode.getNextNode();
        }
        iteratorNode.setNextNode(temp);



    }


    class Node<T> {
        private T value;
        private Node<T> nextNode;

        public T getValue() {
            return value;
        }

        public void setValue(T element) {
            this.value = element;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }


    }
}
