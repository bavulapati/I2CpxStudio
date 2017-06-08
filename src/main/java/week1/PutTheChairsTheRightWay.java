package week1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * It is important that, during the competition, the participants sit not very far one from another.
 * Created by balakrishna on 08-Jun-17.
 */

public class PutTheChairsTheRightWay {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("IOFiles/" + PutTheChairsTheRightWay.class.getSimpleName() + "-input.txt"));
             PrintWriter output = new PrintWriter(new File("IOFiles/" + PutTheChairsTheRightWay.class.getSimpleName() + "-output.txt"))) {
            int side1, side2, side3;
            side1 = input.nextInt();
            side2 = input.nextInt();
            side3 = input.nextInt();
            double averageDistance = (side1 + side2 + side3) / 6.0;
            output.println(averageDistance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
