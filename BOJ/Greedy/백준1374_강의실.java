package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0730_1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new lecture(number, start, end));
        }
        Collections.sort(lectures, (o1, o2) -> o1.start - o2.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures.get(0).end);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lectures.get(i).start) {
                pq.poll();
            }
            pq.add(lectures.get(i).end);
        }
        System.out.println(pq.size());
    }

    static class lecture {
        int number;
        int start;
        int end;

        public lecture(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }
}
