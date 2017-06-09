package week2;

/**
 * Implementation of Queue using two stacks while maintaining the minimum at every state.
 * Created by balakrishna on 08-Jun-17.
 */

class QueueWithTwoStacksWithMinimum {
    private StackWithMinimum enqueStack, dequeStack;

    QueueWithTwoStacksWithMinimum(int n) {
        enqueStack = new StackWithMinimum(n);
        dequeStack = new StackWithMinimum(n);
    }

    void enque(int x) {
        enqueStack.push(x);
    }

    int deque() {
        if (dequeStack.isEmpty())
            while (!enqueStack.isEmpty())
                dequeStack.push(enqueStack.pop());
        return dequeStack.pop();

    }

    public int getMinimum() {
        if (dequeStack.isEmpty())
            return enqueStack.getMinimum();
        else if (enqueStack.isEmpty())
            return dequeStack.getMinimum();
        else
            return (enqueStack.getMinimum() > dequeStack.getMinimum()) ? dequeStack
                    .getMinimum() : enqueStack.getMinimum();
    }
}