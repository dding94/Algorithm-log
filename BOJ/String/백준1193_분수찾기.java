package 백준.PS12월;

import java.io.*;

public class PS1214_1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int n = 0;
        int top = 1;
        int bot = 1;
        int count = 0;

        if (x == 1) {
            System.out.println("1/1");
        } else {
            while (count < x) {
                n++;
                count = n * (n + 1) / 2;
            }
            int num = x - (n - 1) * n / 2;
            if (n % 2 == 0) {
                top = num;
                bot = n - num + 1;
            } else {
                top = n - num + 1;
                bot = num;
            }
            System.out.println(top + "/" + bot);
        }
    }

}
