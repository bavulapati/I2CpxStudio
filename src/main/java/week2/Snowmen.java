package week2;

import java.io.IOException;

import week1.FastIOTemplate;

/**
 * The ﬁrst line contains a number N (1≤N≤106), the number of actions performed by the children.
 * The following N lines contain descriptions of these actions.
 * An (i+1)-st line of the input ﬁle contains a description of the i-th action, which can be one of the following:
 * ->t m: clone the t-th snowman (0≤t<i) and add a snowball with a mass of m (1≤m≤1000) atop it;
 * ->t 0: clone the t-th snowman (0≤t<i) and remove the topmost snowball.
 * It is guaranteed that the t-th snowman is not empty.
 * Initially, there is an empty snowman with the number of 0.
 * Created by balakrishna on 08-Jun-17.
 */

public class Snowmen extends FastIOTemplate {
    public static void main(String[] args) throws IOException {
        try (Snowmen snowmen = new Snowmen()) {
            snowmen.run(Snowmen.class.getSimpleName());
        }
    }

    @Override
    public void solve() throws IOException {
        int n = input.nextInt();
        Snowman[] snowmen = new Snowman[n + 1];
        snowmen[0] = new Snowman();
        snowmen[0].nextMan = null;
        snowmen[0].mass = 0;
        long totalMass = 0;
        for (int i = 1; i < n + 1; i++) {
            snowmen[i] = new Snowman();
            int t = input.nextInt();
            int m = input.nextInt();
            if (m == 0) {
                snowmen[i].nextMan = snowmen[t].nextMan.nextMan;
                totalMass += snowmen[i].mass = snowmen[t].nextMan.mass;
            } else {
                snowmen[i].nextMan = snowmen[t];
                totalMass += snowmen[i].mass = snowmen[t].mass + m;
            }
        }
        output.println(totalMass);
    }
}

class Snowman {
    Snowman nextMan;
    int mass;
}
