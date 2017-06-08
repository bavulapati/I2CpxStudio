package week2;

import java.io.IOException;

import week1.FastIOTemplate;

/**
 * Implement a stack which supports push and pop operations.
 * For every pop operation, output its result.
 * Created by balakrishna on 08-Jun-17.
 */

public class StackProblem extends FastIOTemplate {

    @Override
    protected void solve() throws NumberFormatException, IOException {
        int n = input.nextInt();
        Stack stack = new Stack(n);
        for (int i = 0; i < n; i++) {
            String op = input.next();
            if (op.equals("+"))
                stack.push(input.nextInt());
            else
                output.println(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        try (StackProblem stackProblem = new StackProblem()) {
            stackProblem.run(StackProblem.class.getSimpleName());
        }
    }
}