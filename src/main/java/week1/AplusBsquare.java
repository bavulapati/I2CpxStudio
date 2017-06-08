package week1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Given two integer numbers, A and B, output A+B^2.
 * Created by balakrishna on 08-Jun-17.
 */

public class AplusBsquare {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("IOFiles/" + AplusBsquare.class.getSimpleName() + "-input.txt"));
             Writer output = new FileWriter(new File("IOFiles/" + AplusBsquare.class.getSimpleName() + "-output.txt"))) {
            long a = input.nextLong();
            long b = input.nextLong();
            output.write("" + (a + b * b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}