package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0925_16499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> hs = new HashSet();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);
            String s = String.valueOf(input);

            hs.add(s);
        }

        System.out.println(hs.size());
    }

}
