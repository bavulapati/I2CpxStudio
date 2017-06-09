package week2;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import week1.FastIOTemplate;

/**
 * Given the list of changes, determine in which order the Obi-Wan Kenobi's lightsabers currently lay.
 * Created by balakrishna on 09-Jun-17.
 */

public class KenobisLightSabers extends FastIOTemplate {
    private Deque<Integer> first, second;

    private void add(int x) throws IOException {
        if (first.isEmpty())
            first.addLast(x);
        else if (first.size() >= second.size())
            second.addLast(x);
        else {
            first.addLast(second.removeFirst());
            second.addLast(x);
        }
    }

    private int take() {
        return (second.isEmpty()) ? first.removeLast() : second.removeLast();
    }

    private void mum() {
        Deque<Integer> tmp = first;
        first = second;
        second = tmp;
        if (first.size() > second.size())
            second.addFirst(first.removeLast());
        else if (second.size() > first.size())
            first.addFirst(second.removeLast());
    }

    private void printLightSabers() {
        output.println(first.size() + second.size());
        for (Integer integer : first)
            output.print(integer + " ");
        for (Integer integer : second)
            output.print(integer + " ");
        output.println();
    }

    public static void main(String[] args) throws IOException {
        try (KenobisLightSabers lightSabers = new KenobisLightSabers()) {
            lightSabers.run(KenobisLightSabers.class.getSimpleName());
        }
    }

    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        first = new ArrayDeque<>(n / 2 + 1);
        second = new ArrayDeque<>(n / 2 + 1);
        for (int i = 0; i < n; i++) {
            String opCode = input.next();
            switch (opCode) {
                case "add":
                    add(input.nextInt());
                    break;
                case "take":
                    take();
                    break;
                default:
                    mum();
                    break;
            }
        }
        printLightSabers();
    }
}
