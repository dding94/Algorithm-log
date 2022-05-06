package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0506_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> q = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            q.add(Long.valueOf((st.nextToken())));
        }

        while (m-- > 0) {
            long sum = q.poll() + q.poll();
            q.add(sum);
            q.add(sum);
        }

        long ans = 0;
        for (Long i : q) {
            ans += i;
        }


        System.out.println(ans);
    }
}
