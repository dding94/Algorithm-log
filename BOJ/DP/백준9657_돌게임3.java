package 백준.PS12월;

import java.io.*;

public class PS1210_9657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 7 == 2 || n % 7 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

}
