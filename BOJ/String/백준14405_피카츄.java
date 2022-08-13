package 백준.PS8월;

import java.io.*;

public class PS0813_14405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s = s.replaceAll("pi|ka|chu", "");

        System.out.println(s.equals("") ? "YES" : "NO");
    }
}
