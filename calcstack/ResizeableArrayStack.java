// ResizeableArrayStack.java
public class ResizeableArrayStack<T> {
    private T[] stackArray;
    private int top;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ResizeableArrayStack() {
        stackArray = (T[]) new Object[INITIAL_CAPACITY];
        top = -1;
    }

    // Push an element onto the stack
    public void push(T item) {
        if (top + 1 == stackArray.length) {
            resize(2 * stackArray.length);
        }
        stackArray[++top] = item;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        T item = stackArray[top];
        stackArray[top--] = null; // Avoid loitering
        // Shrink size of array if necessary
        if (top > 0 && top == stackArray.length / 4) {
            resize(stackArray.length / 2);
        }
        return item;
    }

    // Peek at the top element without removing
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Resize the underlying array to the given capacity
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(stackArray, 0, newArray, 0, top + 1);
        stackArray = newArray;
    }

    // Optional: Get current size of the stack
    public int size() {
        return top + 1;
    }
}
