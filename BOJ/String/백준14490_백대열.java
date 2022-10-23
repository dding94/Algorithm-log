package 백준.PS10월;

import java.io.*;

public class PS1006_14490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(":");
        int a = Integer.parseInt(word[0]);
        int b = Integer.parseInt(word[1]);

        int gcd = gcd(a, b);

        System.out.println(a / gcd + ":" + b / gcd);

    }

    private static int gcd(int a, int b) {
        while (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
