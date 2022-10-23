package 백준.PS9월;

import java.io.*;

public class PS0921_1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        s = s.replaceAll("XXXX", "AAAA");
        s = s.replaceAll("XX", "BB");

        if (s.contains("X")) {
            System.out.println(-1);
            return;
        }

        System.out.println(s);
    }
}
