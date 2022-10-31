package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1031_19638 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        for (int i = 0; i < t; i++) {
            if (centiHeight > q.peek()) {
                break;
            }

            if (q.peek() != 1) {
                q.add(q.poll() / 2);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (centiHeight <= q.peek()) {
            sb.append("NO" + "\n" + q.peek());
        } else {
            sb.append("YES" + "\n" + count);
        }

        System.out.println(sb);
    }

}
