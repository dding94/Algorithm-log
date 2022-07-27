package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0727_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        if (n != 1) {
            while (pq.peek() >= dasom) {
                answer++;
                dasom++;
                pq.add(pq.poll() - 1);
            }
        }

        System.out.println(answer);
    }
}
