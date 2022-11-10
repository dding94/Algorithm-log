package 백준.PS11월;

import java.io.*;

public class PS1110_9656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(n % 2 == 0 ? "SK" : "CY");

    }

}
