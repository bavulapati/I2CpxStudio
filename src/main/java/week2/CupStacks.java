package week2;

import java.io.IOException;
import java.util.PriorityQueue;

import week1.FastIOTemplate;

/**
 * Maria needs to know the number of cups of the biggest stack.
 * Created by balakrishna on 09-Jun-17.
 */

public class CupStacks extends FastIOTemplate {

    @Override
    protected void solve() throws NumberFormatException, IOException {
        int n = input.nextInt();
        java.util.Queue<Integer> priorityQueue = new PriorityQueue<>();
        int big = 1;
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            if (x != 0 || i == 0) {
                priorityQueue.add(1);
            } else {
                int y = priorityQueue.remove();
                priorityQueue.add(y + 1);
                big = big > y + 1 ? big : y + 1;
            }
        }
        output.println(big);
    }

    public static void main(String[] args) throws IOException {
        try (CupStacks cupStacks = new CupStacks()) {
            cupStacks.run(CupStacks.class.getSimpleName());
        }
    }
}