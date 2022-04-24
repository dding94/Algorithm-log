package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0424_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Balloon> q = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (q.size() > 1) {
            Balloon now = q.poll();
            sb.append(now.point + " ");

            int move = now.num;
            if (move < 0) {
                while (move++ < 0) {
                    q.addFirst(q.pollLast());
                }
            }

            if (move > 0) {
                move--;
                while (move-- > 0) {
                    q.addLast(q.pollFirst());
                }
            }
        }

        sb.append(q.poll().point);
        System.out.println(sb);
    }


    static class Balloon {
        int point;
        int num;

        public Balloon(int point, int num) {
            this.point = point;
            this.num = num;
        }
    }
}
