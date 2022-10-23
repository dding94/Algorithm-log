package 백준.PS9월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0920_15312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int k = 0;
        n = Integer.parseInt(br.readLine());

        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = br.readLine();
        }

        for (int i = 0; i < n - 1; i++) {
            k += name[i].compareTo(name[i + 1]) > 0 ? 1 : -1;
        }

        if (k == n - 1) {
            System.out.println("DECREASING");
        } else if (k == 1 - n) {
            System.out.println("INCREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
