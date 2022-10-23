package 백준.PS9월;

import java.io.*;

public class PS0929_1812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int totalCandy = 0;
        int[] sumCandy = new int[n];

        for (int i = 0; i < n; i++) {
            sumCandy[i] = Integer.parseInt(br.readLine());
            totalCandy += sumCandy[i];
        }

        totalCandy /= 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = i % 2;
            int temp = totalCandy;
            if (i < 2) {
                count = i + 1;
            }
            while (true) {
                if (count >= n) {
                    break;
                }
                if (count == i) {
                    count++;
                    continue;
                }
                temp -= sumCandy[count];
                count += 2;
            }
            sb.append(temp + "\n");
        }

        System.out.println(sb);
    }
}
