package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0709_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Set<String> hs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);

            for (int j = i; j < s.length(); j++) {
                sb.append(s.substring(j, j + 1));
                hs.add(sb.toString());
            }
        }

        System.out.println(hs.size());
    }
}
