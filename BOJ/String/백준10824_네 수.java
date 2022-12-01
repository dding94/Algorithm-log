package 백준.PS12월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1201_10824 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        String d = st.nextToken();

        String ab = a + b;
        String cd = c + d;

        long result = Long.parseLong(ab) + Long.parseLong(cd);
        System.out.println(result);
    }
}
