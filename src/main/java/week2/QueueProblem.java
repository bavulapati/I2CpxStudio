package week2;

import java.io.IOException;

import week1.FastIOTemplate;

/**
 * Implement a queue which supports push and pop operations.
 * For every pop operation, output its result.
 * Created by balakrishna on 08-Jun-17.
 */

public class QueueProblem extends FastIOTemplate {
    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        Queue queue = new Queue(n);
        for (int i = 0; i < n; i++) {
            String opCode = input.next();
            if (opCode.equals("+"))
                queue.enque(input.nextInt());
            else
                output.println(queue.deque());
        }
    }

    public static void main(String[] args) throws IOException {
        try (QueueProblem queueProblem = new QueueProblem()) {
            queueProblem.run(QueueProblem.class.getSimpleName());
        }
    }
}