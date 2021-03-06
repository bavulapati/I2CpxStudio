package week1;

import java.io.IOException;

/**
 * Help Jamie construct such a timetable which increases his ability to solve problems to a maximum possible value.
 * Created by balakrishna on 08-Jun-17.
 */


public class PrepareYourselfToCompetitions extends FastIOTemplate {

    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        int p[] = new int[n], t[] = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = input.nextInt();
        for (int i = 0; i < n; i++)
            t[i] = input.nextInt();
        int pDays = 0, tDays = 0, productivity = 0;

        for (int i = 0; i < n; i++) {
            if (p[i] > t[i]) {
                productivity += p[i];
                pDays++;
            } else {
                productivity += t[i];
                tDays++;
            }
        }
        int minDiff = Integer.MAX_VALUE;
        if (pDays == 0) {
            for (int i = 0; i < n; i++) {
                int curDiff = t[i] - p[i];
                if (curDiff < minDiff)
                    minDiff = curDiff;
            }
            productivity = productivity - minDiff;
        } else if (tDays == 0) {
            for (int i = 0; i < n; i++) {
                int curDiff = p[i] - t[i];
                if (curDiff < minDiff)
                    minDiff = curDiff;
            }
            productivity = productivity - minDiff;
        }
        output.println(productivity);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (PrepareYourselfToCompetitions prepareYourselfToCompetitions = new PrepareYourselfToCompetitions()) {
            prepareYourselfToCompetitions.run(PrepareYourselfToCompetitions.class.getSimpleName());
        }
    }
}