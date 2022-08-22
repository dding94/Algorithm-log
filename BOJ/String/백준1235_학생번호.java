package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0822_1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> hs = new HashSet<>();

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        int len = input[0].length();

        for (int i = 1; i <= len; i++) {

            for (int j = 0; j < n; j++) {
                hs.add(input[j].substring(len - i));
            }

            if (hs.size() == n) {
                System.out.println(i);
                return;
            }
            hs.clear();
        }

    }
}
