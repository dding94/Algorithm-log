package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1028_1337 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int max = 0;
        int end = n < 5 ? 1 : n;

        for (int i = 0; i < end; i++) {
            int standardNum = list.get(i) + 4;
            int count = 0;
            for (int j = 0; j < n - i; j++) {
                int temp = list.get(i + j);
                if (standardNum >= temp) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > max) {
                max = count;
            }

        }
        System.out.println(5 - max);
    }

}
