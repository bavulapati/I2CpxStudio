package week2;

import java.io.IOException;

import week1.FastIOTemplate;

/**
 * In postﬁx notation (or reverse Polish notation) an operation is written directly after its operands.
 * For instance, a sum of two numbers, A + B, is written as A B +.
 * Given an expression in postﬁx notation, evaluate it.
 * Created by balakrishna on 08-Jun-17.
 */

public class PostfixNotation extends FastIOTemplate {
    public static void main(String[] args) throws IOException {
        try (PostfixNotation postfixNotation = new PostfixNotation()) {
            postfixNotation.run(PostfixNotation.class.getSimpleName());
        }
    }

    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        Stack stack = new Stack(n);
        for (int i = 0; i < n; i++) {
            int secondOperand, firstOperand;
            int currentChar = input.nextChar();
            switch (currentChar) {
                default:
                    stack.push(Character.getNumericValue(currentChar));
                    break;
                case '+':
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();
                    stack.push(firstOperand + secondOperand);
                    break;
                case '-':
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();
                    stack.push(firstOperand - secondOperand);
                    break;
                case '*':
                    secondOperand = stack.pop();
                    firstOperand = stack.pop();
                    stack.push(firstOperand * secondOperand);
                    break;
            }
            input.nextChar();
        }
        output.println(stack.pop());
    }
}
