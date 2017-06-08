package week2;

/**
 * Simple implementation of Queue.
 * Created by balakrishna on 08-Jun-17.
 */

class Queue {
    private int[] storage;
    private int head;
    private int tail;

    Queue(int n) {
        storage = new int[n];
    }

    void enque(int x) {
        storage[head++] = x;
    }

    int deque() {
        return storage[tail++];
    }
}