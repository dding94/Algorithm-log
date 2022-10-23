package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1004_14235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (!q.isEmpty()) {
                    sb.append(q.poll() + "\n");
                } else {
                    sb.append("-1" + "\n");
                }
            }
            if (a != 0) {
                for (int j = 0; j < a; j++) {
                    q.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.println(sb);
    }

}
