package week1;

import java.io.IOException;
import java.util.HashMap;

/**
 * Alice, Beatrice and Cynthia each proposed her own template for her favourite programming language.
 * Please help them to choose the optimal ones!
 * Created by balakrishna on 08-Jun-17.
 */

public class WriteACodeTemplate extends FastIOTemplate {

    private class CharPosition {
        int x, y;

        CharPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private String chars;
    private int i;
    private HashMap<Integer, CharPosition> alphabet = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (WriteACodeTemplate aCodeTemplate = new WriteACodeTemplate()) {
            aCodeTemplate.run(WriteACodeTemplate.class.getSimpleName());
        }
    }

    private int nextChar() throws IOException {
        if (chars == null || i == chars.length()) {
            chars = input.next();
            i = 0;
            if (chars.equals("%TEMPLATE-START%")) {
                chars = null;
                return nextChar();
            } else if (chars.equals("%TEMPLATE-END%")) {
                chars = null;
                return -1;
            }
        }
        return chars.charAt(i++);
    }

    @Override
    protected void solve() throws NumberFormatException, IOException {
        int w = input.nextInt();
        int h = input.nextInt();
        for (int i = h; i > 0; i--)
            for (int j = 1; j <= w; j++)
                alphabet.put(nextChar(), new CharPosition(i, j));
        String bestLanguage = null, currentLanguage;
        int bestTime = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            currentLanguage = input.next();
            if (bestLanguage == null)
                bestLanguage = currentLanguage;
            int startChar = nextChar(), nextChar, totalTime = 0;
            if (startChar != -1)
                while ((nextChar = nextChar()) != -1) {
                    int currentTime = distance(startChar, nextChar);
                    totalTime += currentTime;
                    startChar = nextChar;
                }
            if (bestTime > totalTime) {
                bestTime = totalTime;
                bestLanguage = currentLanguage;
            }
        }
        output.println(bestLanguage);
        output.println(bestTime);
    }

    private int distance(int startChar, int nextChar) {
        CharPosition startPosition = alphabet.get(startChar);
        CharPosition endPosition = alphabet.get(nextChar);
        return Math.max(Math.abs(startPosition.x - endPosition.x), Math.abs(startPosition.y - endPosition.y));
    }

}
