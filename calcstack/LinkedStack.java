// LinkedStack.java
public class LinkedStack<T> {
    private Node<T> top;

    // Node class representing each element in the stack
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Constructor
    public LinkedStack() {
        top = null;
    }

    // Push an element onto the stack
    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        T item = top.data;
        top = top.next;
        return item;
    }

    // Peek at the top element without removing
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
