package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1005_23757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2 - o1);
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            p.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            int max = p.poll();
            if (now > max) {
                System.out.println(0);
                return;
            }
            p.add(max - now);
        }
        System.out.println(1);
    }

}
