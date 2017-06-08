package week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Output the single number – the maximum number of problems, which Dream Team can solve.
 * Created by balakrishna on 08-Jun-17.
 */

public class WinTheCompetition {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("IOFiles/" + WinTheCompetition.class.getSimpleName() + "-input.txt"));
             PrintWriter output = new PrintWriter(new File("IOFiles/" + WinTheCompetition.class.getSimpleName() + "-output.txt"))) {
            int n = input.nextInt();
            int[] jobDurations = new int[n];
            for (int i = 0; i < n; i++)
                jobDurations[i] = input.nextInt();
            Arrays.sort(jobDurations);
            int totalDuration = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (totalDuration + jobDurations[i] <= 18000) {
                    totalDuration += jobDurations[i];
                    count++;
                }
            }
            output.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
