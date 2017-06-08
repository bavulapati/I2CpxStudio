package week2;

import java.io.IOException;

import week1.FastIOTemplate;

/**
 * For every line from the input ﬁle output “YES” if it is a correct bracket sequence, and “NO” otherwise.
 * A sequence A of characters “(”, “)”, “[”, “]” is called a correct bracket sequence, if one of the following is true:
 * ->A is empty.
 * ->The ﬁrst character of A is “(”, and A contains a character “)”, such that A=(B)C, where B and C are correct bracket sequences.
 * ->The ﬁrst character of A is “[”, and A contains a character “]”, such that A=[B]C, where B and C are correct bracket sequences
 * For example, the sequences “(())” and “()[]” are correct, while the sequences “[)” and “((” are not correct.
 * Created by balakrishna on 08-Jun-17.
 */

public class BracketSequence extends FastIOTemplate {
    public static void main(String[] args) throws IOException {
        try (BracketSequence bracketSequence = new BracketSequence()) {
            bracketSequence.run(BracketSequence.class.getSimpleName());
        }
    }

    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        Stack stack;
        for (int i = 0; i < n; i++) {
            String sequence = input.next();
            stack = new Stack(sequence.length());
            int j;
            for (j = 0; j < sequence.length(); j++) {
                char bracket = sequence.charAt(j);
                if (bracket == '(') {
                    stack.push(1);
                } else if (bracket == '[') {
                    stack.push(2);
                } else if (bracket == ')') {
                    if (stack.isEmpty() || stack.pop() != 1)
                        break;
                } else if (stack.isEmpty() || stack.pop() != 2)
                    break;
            }
            if (stack.isEmpty() && j == sequence.length())
                output.println("YES");
            else
                output.println("NO");
        }
    }
}
