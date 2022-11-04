package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1104_23843 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            q.add(0);
        }

        for (int i = 0; i < n; i++) {
            q.add(q.poll() + list.get(i));
        }

        for (int i = 0; i < m - 1; i++) {
            q.poll();
        }

        System.out.println(q.peek());
    }

}
