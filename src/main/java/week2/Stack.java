package week2;

/**
 * Simple stack implementation using array
 * Created by balakrishna on 08-Jun-17.
 */

class Stack {
    private int[] storage;
    protected int top;
    Stack(int n) {
        storage = new int[n];
        top = -1;
    }

    void push(int x) {
        if(top == storage.length)
            System.out.println("Stack is full");
        else
            storage[++top] = x;
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        else
            return storage[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }
}