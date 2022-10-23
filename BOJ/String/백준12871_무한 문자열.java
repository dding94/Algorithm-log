package 백준.PS9월;

import java.io.*;

public class PS0916_12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int aLength = a.length();
        int bLength = b.length();

        int lcm = lcm(aLength, bLength);

        StringBuilder aSb = new StringBuilder();
        StringBuilder bSb = new StringBuilder();

        for (int i = 0; i < lcm / aLength ; i++) {
            aSb.append(a);
        }

        for (int i = 0; i < lcm / bLength ; i++) {
            bSb.append(b);
        }

        System.out.println(aSb.toString().equals(bSb.toString()) ? 1 : 0);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
