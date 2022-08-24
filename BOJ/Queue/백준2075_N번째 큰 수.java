package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0824_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>();
        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (q.size() == n) {
                    if (q.peek() < num) {
                        q.poll();
                        q.add(num);
                    }
                } else {
                    q.add(num);
                }
            }
        }
        System.out.println(q.poll());
    }

}
