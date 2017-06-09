package week2;

import java.io.IOException;

import week1.FastIOTemplate;

/**
 * Implement a queue which supports push and pop operations,
 * and additionally a minimum query, which returns a minimum among the elements in the queue.
 * For every minimum query, output its result.
 * Created by balakrishna on 08-Jun-17.
 */

public class QueueWithMinimumQueryProblem extends FastIOTemplate {
    public static void main(String[] args) throws IOException {
        try (QueueWithMinimumQueryProblem queueWithMinimumQueryProblem = new QueueWithMinimumQueryProblem()) {
            queueWithMinimumQueryProblem.run(QueueWithMinimumQueryProblem.class.getSimpleName());
        }
    }

    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        QueueWithTwoStacksWithMinimum queue = new QueueWithTwoStacksWithMinimum(n);
        for (int i = 0; i < n; i++) {
            String opCode = input.next();
            switch (opCode) {
                case "+":
                    queue.enque(input.nextInt());
                    break;
                case "-":
                    queue.deque();
                    break;
                default:
                    output.println(queue.getMinimum());
                    break;
            }
        }
    }
}