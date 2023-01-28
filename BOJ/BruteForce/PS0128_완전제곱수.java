package 백준23.PS1월;

import java.io.*;
import java.util.*;

public class PS0128_완전제곱수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            numbers.add(i * i);
        }

        int min = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = n; i <= m; i++) {
            if (numbers.contains(i)) {
                min = Math.min(min, i);
                answer += i;
            }
        }

        if (answer == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer + 1);
        System.out.println(min);
    }

}
