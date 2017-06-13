package week1;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Reads data from file efficiently
 * Created by balakrishna on 08-Jun-17.
 */


public class FastScanner implements Closeable {
    private BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    FastScanner(File inputFile) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(inputFile));

    }

    public int nextChar() throws IOException {
        return bufferedReader.read();
    }

    public String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            String line = bufferedReader.readLine();
            if (line == null)
                return null;
            stringTokenizer = new StringTokenizer(line);
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(next());
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
        stringTokenizer = null;
    }
}