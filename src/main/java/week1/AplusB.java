package week1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Given two integer numbers, A and B, output A+B.
 * Created by balakrishna on 08-Jun-17.
 */

public class AplusB {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("IOFiles/" + AplusB.class.getSimpleName() + "-input.txt"));
             Writer output = new FileWriter(new File("IOFiles/" + AplusB.class.getSimpleName() + "-output.txt"))) {
            int a = input.nextInt();
            int b = input.nextInt();
            output.write("" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}