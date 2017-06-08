package week1;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Reads the input from file efficiently
 * Created by balakrishna on 08-Jun-17.
 */

public abstract class FastIOTemplate implements Closeable {
    protected FastScanner input;
    protected PrintWriter output;

    protected abstract void solve() throws NumberFormatException, IOException;

    protected void run(String problemName) throws NumberFormatException, IOException {
        input = new FastScanner(new File("IOFiles/" + problemName + "-input.txt"));
        output = new PrintWriter(new File("IOFiles/" + problemName + "-output.txt"));
        solve();
    }

    @Override
    public void close() throws IOException {
        input.close();
        output.close();
    }
}