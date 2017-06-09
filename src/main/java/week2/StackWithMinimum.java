package week2;

/**
 * Stack which maintains the minimum at every state.
 * Created by balakrishna on 08-Jun-17.
 */

class StackWithMinimum extends Stack {
    private int[] minStack;

    StackWithMinimum(int n) {
        super(n);
        minStack = new int[n];
    }

    @Override
    public void push(int x) {
        minStack[top + 1] = (top == -1) ? x : (minStack[top] > x) ? x
                : minStack[top];
        super.push(x);
    }

    public int getMinimum() {
        return minStack[top];
    }
}
